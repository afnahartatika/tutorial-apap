import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Cart = (props) => {
    const { id, idItem, quantity, item} = props;
    return (
        <div className={classes.cart}>
            <h3>{`ID Cart: ${id}`}</h3>
            <p>{`Nama Barang: ${item.title}`}</p>
            <p>{`Harga: ${item.price}`}</p>
            <p>{`Deskripsi: ${item.description}`}</p>
            <p>{`Kategori: ${item.category}`}</p>
            <p><strong>{`Total Harga: ${item.price}`}</strong></p>
        </div>
    );
};
export default Item;