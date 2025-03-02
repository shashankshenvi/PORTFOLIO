import React from "react";
import styles from "./Experience.module.css";
import history from "../../data/history.json";
import { getImageUrl } from "../../utils";

export const Experience = () => {
  return (
    <section className={styles.experienceContainer} id="experience">
      <h2 className={styles.experienceHeader}>Experience</h2>

      <div className={styles.experienceGrid}>
        {history.map((historyItem, id) => (
          <div key={id} className={styles.experienceItem}>
            {/* Logo Container */}
            <div className={styles.logoContainer}>
              <img
                src={getImageUrl(historyItem.imageSrc)}
                alt={`${historyItem.organisation} Logo`}
              />
            </div>

            {/* Role & Organization */}
            <div className={styles.textContainer}>
              <h3 className={styles.roleHeader}>
                {historyItem.role} <br /> {historyItem.organisation}
              </h3>
              <p className={styles.dates}>
                {historyItem.startDate} - {historyItem.endDate}
              </p>

              {/* Work Experience List */}
              <ul className={styles.experiences}>
                {historyItem.experiences.map((experience, idx) => (
                  <li key={idx}>{experience}</li>
                ))}
              </ul>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
};

export default Experience;
