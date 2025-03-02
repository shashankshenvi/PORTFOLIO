import React, { useState, useEffect } from "react";
import styles from "./Skills.module.css";
import { getImageUrl } from "../../utils";

export const Skills = () => {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    const fetchSkills = async () => {
      try {
        console.log("Fetching skills from backend...");

        const response = await fetch("http://localhost:8080/api/skills"); // Change URL if needed
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        console.log("API Response:", data);

        // Filter only active skills
        const filteredSkills = data
          .filter((skill) => skill.isActive === "Y")
          .map(({ title, imageSrc }) => ({ title, imageSrc }));

        setSkills(filteredSkills);
      } catch (error) {
        console.error("Error fetching skills:", error);
      }
    };

    fetchSkills();
  }, []);

  return (
    <section className={styles.skillsContainer} id="skills">
      <h2 className={styles.skillsHeader}>SKILLS</h2>
      <div className={styles.skillsGrid}>
        {skills.map((skill, id) => (
          <div key={id} className={styles.skill}>
            <div className={styles.skillImageContainer}>
              <img src={getImageUrl(skill.imageSrc)} alt={skill.title} />
            </div>
            <p>{skill.title}</p>
          </div>
        ))}
      </div>
    </section>
  );
};
