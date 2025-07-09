import React, { useState } from "react";
import "./PetCard.css";
import { CiHeart } from "react-icons/ci";
import { FaHeart } from "react-icons/fa";
import { Link } from "react-router-dom";

export default function PetCard(props) {
    // console.log(props);
    const [isFavorite, setIsFavorite] = useState(false);

    const handleFavorite = () => {
    setIsFavorite((prev) => !prev);
};
return (
    <div className="cont">
    <div className="product-card">
        <div className="product-card__image">
        <img src={props.img} alt={props.breed} />
        </div>
        <div className="product-card__info">
        <h2 className="product-card__title">
            {props.name} <span className="breed">{props.breed}</span>
        </h2>
        <p className="product-card__description">{props.description}</p>
        <div className="product-card__price-row">
            <span
            className="product-card__price"
            onClick={handleFavorite}
            style={{ cursor: "pointer" }}
            aria-label={
                isFavorite ? "Remove from favorites" : "Add to favorites"
            }
            role="button"
            tabIndex={0}
            onKeyPress={(e) => {
                if (e.key === "Enter" || e.key === " ") handleFavorite();
            }}
            >
            {isFavorite ? (
                <FaHeart
                style={{
                    fontSize: "1.8rem",
                    fontWeight: "bold",
                    color: "red",
                }}
                />
            ) : (
                <CiHeart style={{ fontSize: "2rem", fontWeight: "bold" }} />
            )}
            </span>
            <Link to={`/pet-details/${props.id || props.pet_id || ""}`}>
            <button className="product-card__btn">Get Details</button>
            </Link>
        </div>
        </div>
    </div>
    </div>
);
}
