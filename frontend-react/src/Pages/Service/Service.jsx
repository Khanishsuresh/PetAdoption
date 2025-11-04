import React from 'react'
import './Service.css'
import ServiceCard from './ServiceCard';
import shelterImage from "../../assets/shelter.jpg";
import puppyImage from "../../assets/puppy.jpg";
import helpImage from "../../assets/help.jpg";

export default function Service() {

  const services = [
    {
      img: puppyImage,
      title: "Pet Adoption",
      description: "Search for your perfect companion among our rescued animals and give them a loving home.",
      route : '/pet-listing'
    },
    {
      img: shelterImage,
      title: "Find Shelters",
      description: "Locate animal shelters near you, explore available pets, and connect with shelter.",
      route : '/shelter-listing'
    },
    {
      img: helpImage,
      title: "Help & Save a Pet",
      description: "Support rescued animals by donating, volunteering, or fostering a pet in need of care.",
      route : '/shelter-listing',
      link : ''
    }
  ];
  
  return (
    <div className='service-page' id='services'>
          <div className='service-container'>
              <div className='service-header'>
                <h1>Our Services</h1>
              </div>
              <div className='service-content'>
                {
                  services.map((service, index) => (
                      <ServiceCard key= {index} img = {service.img} title = {service.title} description = {service.description} route = {service.route} />
                  ))
                }
              </div>
          </div>   
    </div>
  )
}
