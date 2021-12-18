import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import { IconButton } from '@material-ui/core';
import { Fab } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            cart: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            search: "",
            cartHidden: true,
            cartQty: 0
        };
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearchItem = this.handleSearchItem.bind(this);
        this.handleChangeSearchField = this.handleChangeSearchField.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.handleAddItemToCart = this.handleAddItemToCart.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const {data} = await APIConfig.get(`/item?title=${this.state.search}`);
            this.setState({items: data.result});
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadDataCart() {
        try {
            const {data} = await APIConfig.get("/cart");
            this.setState({cart: data.result});
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteItem(item) {
        // event.preventDefault();
        console.log("test");
        await APIConfig.delete(`/item/${item.id}`);
        this.loadData();
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({isLoading: !currentLoading});
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({ isCreate:true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    // latihan no 2
    handleSearchItem(event) {
        const { search, value } = event.target;
        this.setState({ title: value });
    }

    // latihan no 2
    handleChangeSearchField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        this.loadData();
    }

    // latihan no 3
    async handleAddItemToCart(event) {
        const qty = document.getElementById("qty" + event.id).value; // input form quantity item
        const cart = [...this.state.cart];
        try {

            // item pertama di cart
            if (cart.length === 0) {
                if (qty <= event.quantity) {
                    const data = {
                        idItem: event.id,
                        quantity: qty
                    };
                    await APIConfig.post("/cart", this.state.data);
                    this.loadData();
                    this.loadDataCart();
                }
            }

            else {
                for(let i = 0; i < cart.length; i++) {
                    const j = cart[i];
                    if (j.item.id === event.id) {
                        if (qty <= event.quantity - j.quantity) {
                            const data = {
                                idItem: event.id,
                                quantity: qty
                            };

                            await APIConfig.post("/cart", data);
                            this.loadData();
                            this.loadDataCart();
                        }

                        else {
                            alert("Stok tidak memenuhi!");
                        }
                    }

                    else {
                        if (qty <= event.quantity) {
                            const data = {
                                idItem: event.id,
                                quantity: qty
                            };

                            await APIConfig.post("/cart", data);
                        }
                    } alert("Stok tidak memenuhi!");
                }
            }
        } catch (error) {
            alert("Error!");
        }
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    }

    render() {
        return (
            <div className={classes.itemList}>
                {this.state.cartHidden ?
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                            <Badge color="secondary" badgeContent={this.state.cart.length}>
                                <ShoppingCartIcon />
                            </Badge>
                    </Fab>
                </div>
                    : <button className="btn btn-primary" onClick={this.handleToggle}>← BACK</button>}
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <button className="btn btn-primary" onClick={this.handleToggle}>CHECKOUT</button>
                                <h1 className={classes.title}>Cart Items</h1>
                                <div>
                                    {this.state.cart.map((item) => (
                                        <Item
                                            key={item.id}
                                            id={item.id}
                                            title={item.title}
                                            price={item.price}
                                            description={item.description}
                                            category={item.category}
                                            quantity={item.quantity}
                                        />
                                    ))}
                                </div>
                            </div>
                        ) : <div className="col-sm">
                            <h1 className={classes.title}>All Items</h1>
                            <form className="form-control">
                                <input className={classes.textField}
                                       type="text"
                                       placeholder="Search..."
                                       name="search"
                                       value={this.state.search}
                                       onChange={this.handleChangeSearchField}
                                />
                            </form>
                            <Button action={this.handleAddItem}>Add Item</Button>
                            <div>
                                {this.state.items.map((item) => (
                                    <Item
                                        key={item.id}
                                        id={item.id}
                                        title={item.title}
                                        price={item.price}
                                        description={item.description}
                                        category={item.category}
                                        quantity={item.quantity}
                                        handleEdit={() => this.handleEditItem(item)}
                                        handleDelete={() => this.handleDeleteItem(item)}
                                        handleAddCart={() => this.handleAddItemToCart(item)}
                                    />
                                ))}
                            </div>
                        </div>}
                    </div>
                </div>


                <Modal show={this.state.isCreate || this.state.isEdit}
                       handleCloseModal={this.handleCancel}
                       modalTitle={this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`}>
                    <form>
                        <input className={classes.textField}
                               type="text"
                               placeholder="Nama Item"
                               name="title"
                               value={this.state.title}
                               onChange={this.handleChangeField}
                        />
                        <input className={classes.textField}
                               type="number"
                               placeholder="Harga"
                               name="price"
                               value={this.state.price}
                               onChange={this.handleChangeField}
                        />
                        <textarea className={classes.textField}
                                  placeholder="Deskripsi"
                                  name="description"
                                  rows="4"
                                  value={this.state.description}
                                  onChange={this.handleChangeField}
                        />
                        <input className={classes.textField}
                               type="text"
                               placeholder="Kategori"
                               name="category"
                               value={this.state.category}
                               onChange={this.handleChangeField}
                        />
                        <input className={classes.textField}
                               type="number"
                               placeholder="qty"
                               name="quantity"
                               value={this.state.quantity}
                               onChange={this.handleChangeField}
                        />
                        <Button action={this.state.isCreate
                            ? this.handleSubmitItem
                            : this.handleSubmitEditItem}>
                            Create
                        </Button>
                        <Button action={this.handleCancel}>Cancel</Button>
                    </form>
                </Modal>
            </div>
        );

    }
}
export default ItemList;

