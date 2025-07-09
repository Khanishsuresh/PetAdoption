import React from 'react'
import './ServiceCard.css'
import { Link } from 'react-router-dom';

export default function ServiceCard(props) {
  return (
    <div class="card">
        <div class="card-image">
            <img src={props.img} alt="Dragon" />
        </div>
        <div class="card-content">
            <h3 class="title">{props.title}</h3>
            <p class="text">{props.description} </p>
          <Link to={props.route} className='link'>  Explore</Link>
        </div>
        <h2 class="card-title">{props.title}</h2>
    </div>
  )
}
