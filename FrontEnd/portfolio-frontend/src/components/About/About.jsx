import React from "react";
import styles from "./About.module.css";
import { getImageUrl } from "../../utils";

export const About = () => {
  return (
    <section className={styles.container} id="about">
      <h2 className={styles.title}>About</h2>
      <div className={styles.content}>
        <img
          src={getImageUrl("about/developer.jpg")}
          alt="Me sitting with a laptop"
          className={styles.aboutImage}
        />
        <div className={styles.aboutDetails}>
          <h3 className={styles.aboutHeading}>Backend Developer</h3>

          <ul className={styles.aboutItems}>
            <li className={styles.aboutItem}>
              <p>
                I specialize in developing fast and optimized back-end systems
                using <b>Java, Spring, and Hibernate</b>. I designed the
                <b>Dynamic Returns portal</b>, allowing users to create
                customizable data submission templates and seamlessly upload
                data.
              </p>
            </li>

            <li className={styles.aboutItem}>
              <p>
                My expertise includes{" "}
                <b>
                  MySQL schema design, SQL & HQL queries, and data optimization
                </b>
                . I have built and maintained
                <b>RESTful APIs</b> for seamless frontend-backend communication,
                optimized performance with <b>code profiling</b>, and
                implemented security measures such as{" "}
                <b>data encryption & user authentication</b>.
              </p>
            </li>

            <li className={styles.aboutItem}>
              <p>
                I collaborate with{" "}
                <b>QA teams, frontend developers, and product managers</b> to
                ensure robust and efficient solutions.
              </p>
            </li>
          </ul>
        </div>
      </div>
    </section>
  );
};
