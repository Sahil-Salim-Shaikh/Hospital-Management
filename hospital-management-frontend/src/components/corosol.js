import { useState } from "react";
import { Carousel } from "react-bootstrap";
import img1 from "../assets/carosel1.jpeg";
import img2 from "../assets/carosel2.jpg";
import img3 from "../assets/carosel3.jpg";

function CreateCorosol() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex, e) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel
      activeIndex={index}
      onSelect={handleSelect}
      interval={1000} // Set the interval to 1000 milliseconds (1 second)
      style={{ height: "160px", width: "400px" }}
    >
      <Carousel.Item>
        <img
          style={{
            borderStyle: "solid",
            borderColor: "black",
            borderRadius: "20px",
            borderWidth: "5px",
            height: "160px",
            width: "220px",
          }}
          className="d-block w-100"
          src={img1}
          alt=""
        />
      </Carousel.Item>
      <Carousel.Item>
        <img
          style={{
            borderStyle: "solid",
            borderColor: "black",
            borderRadius: "20px",
            borderWidth: "5px",
            height: "160px",
            width: "220px",
          }}
          className="d-block w-100"
          src={img3}
          alt="Second slide"
        />
      </Carousel.Item>
      <Carousel.Item>
        <img
          style={{
            borderStyle: "solid",
            borderColor: "black",
            borderRadius: "20px",
            borderWidth: "5px",
            height: "160px",
            width: "220px",
          }}
          className="d-block w-100"
          src={img2}
          alt="Third slide"
        />
      </Carousel.Item>
    </Carousel>
  );
}

export default CreateCorosol;
