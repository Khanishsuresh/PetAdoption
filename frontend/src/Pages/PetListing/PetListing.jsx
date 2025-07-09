import React, { useEffect, useState } from "react";
import "./PetListing.css";
import Navbar from "../../Components/Navbar/Navbar";
import PetCard from "./PetCard.jsx";
import puppyImage from "../../assets/puppy.jpg";

export default function PetListing() {
  const [pets, setPets] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/api/pets")
      .then((res) => res.json())
      .then((data) => {
        setPets(data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);

  if (loading) return <div>Loading...</div>;

  return (
    <>
      {/* <Navbar /> */}
      <div className="pet-listing-page">
        {pets.map((pet) => {
          // console.log(pet);
          return (
            <PetCard
              key = {pet.id}
              pet_id={pet.id}
              img={puppyImage}
              name={pet.name}
              breed={pet.breed}
              description={pet.description}
            />
          );
        })}
      </div>
    </>
  );
}
