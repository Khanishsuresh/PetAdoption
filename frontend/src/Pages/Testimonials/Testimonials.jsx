import React from 'react';
import './Testimonials.css';
import puppyImage from "../../assets/user.png";

const testimonialData = [
  {
    name: "Emily Rodriguez",
    review: "PetAdopt helped me find my perfect companion! Max, my rescue dog, has brought so much joy to my life. The team was incredibly supportive throughout the entire adoption process.",
    image: puppyImage
  },
  {
    name: "Michael Chen",
    review: "I was hesitant about adopting, but PetAdopt made everything so smooth. Whiskers, my new cat, has been the most loving addition to my family. Highly recommend!",
    image: puppyImage
  },
  {
    name: "Sarah Thompson",
    review: "As a first-time pet owner, I was nervous. The PetAdopt team guided me perfectly. My rescue bunny, Hoppy, has been an absolute delight and has settled in wonderfully!",
    image: puppyImage
  },
  {
    name: "David Kim",
    review: "PetAdopt doesn't just match pets with owners; they create families. Rocky, my adopted dog, has been the most loyal friend I could ask for.",
    image: puppyImage
  }
];

const TestimonialsPage = () => {
  return (
    <div className="testimonials-container" id='testimonials'>
      <div className="testimonials-content">
        <h1>Heartwarming Stories</h1>
        <p className="testimonials-subtitle">See how PetAdopt has changed lives</p>
        
        <div className="testimonial-grid">
          {testimonialData.map((testimonial, index) => (
            <div key={index} className="testimonial-card">
              <div className="testimonial-header">
                <img 
                  src={testimonial.image} 
                  alt={`${testimonial.name}'s profile`} 
                  className="testimonial-avatar"
                />
                <h3 className="testimonial-name">{testimonial.name}</h3>
              </div>
              <p className="testimonial-text">{testimonial.review}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default TestimonialsPage;