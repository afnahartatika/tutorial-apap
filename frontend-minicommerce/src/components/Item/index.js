import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Item = (props) => {
    const { id, title, price, description, category, quantity, handleAddCart, handleEdit, handleDelete} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Price: ${price}`}</p>
            <p>{`Description: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <p>{`Stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <Button action={handleDelete}>
                Delete
            </Button>
            <form>
                <input className="form-control" type="text"/>
                <Button action={handleAddCart}>Add to Cart</Button>
            </form>
        </div>
    );
};
export default Item;