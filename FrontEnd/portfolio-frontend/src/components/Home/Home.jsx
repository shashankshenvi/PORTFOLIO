import React from "react";
import styles from "./Home.module.css";
import { getImageUrl } from "../../utils";

export const Home = () => {
  return (
    <section className={styles.container}>
      <img src={getImageUrl("hero/shashank.png")} className={styles.heroImg} />
      <div className={styles.content}>
        <h1 className={styles.title}>Hi, I am Shashank</h1>
        <p className={styles.description}>
          I have 2 years of IT experience in design, development, maintenance,
          enhancements, and production support. My expertise includes working
          with data warehousing and legacy applications using tools like Apache
          Tomcat, Maven, Spring, and big data technologies. I am seeking a
          challenging position as a Java Backend Developer to leverage my skills
          in building scalable server-side applications, optimizing database
          performance, and contributing to innovative solutions that enhance
          user experience and operational efficiency.
        </p>
      </div>
      <div className={styles.topBlur} />
      <div className={styles.bottomBlur} />
    </section>
  );
};
