import React, { useEffect, useState } from "react";
import styles from "./Contact.module.css";
import { getImageUrl } from "../../utils";

export const Contact = () => {
  const [contact, setContact] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/users") // Change this URL if your backend is running on a different port
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch contact details");
        }
        return response.json();
      })
      .then((data) => {
        const activeUser = data.find((user) => user.isActive === "Y");
        setContact(activeUser);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  const handleResumeDownload = (resumePath) => {
    const validExtensions = [".doc", ".docx", ".pdf"];
    const extension = resumePath
      .slice(resumePath.lastIndexOf("."))
      .toLowerCase();

    if (validExtensions.includes(extension)) {
      const link = document.createElement("a");
      link.href = resumePath;
      link.download = resumePath.split("/").pop();
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    } else {
      alert("Unsupported file format for download.");
    }
  };

  if (loading) return <p>Loading contact details...</p>;
  if (error) return <p>Error: {error}</p>;
  if (!contact) return <p>No active contact details found.</p>;

  return (
    <footer id="contact" className={styles.container}>
      <div className={styles.text}>
        <h2>Contact</h2>
        <p>Feel free to reach out!</p>
      </div>
      <ul className={styles.links}>
        {contact.contacts &&
          contact.contacts.map((contactItem, index) => (
            <li key={index} className={styles.link}>
              <img
                src={getImageUrl(contactItem.imageSrc)}
                alt={`${contactItem.type} icon`}
              />
              {contactItem.type === "resume" ? (
                <span
                  onClick={() => handleResumeDownload(contactItem.value)}
                  className={styles.downloadIcon}
                >
                  Resume
                </span>
              ) : (
                <a
                  href={
                    contactItem.type === "mail"
                      ? `mailto:${contactItem.value}`
                      : contactItem.type === "phone"
                      ? `tel:${contactItem.value}` // Added phone support
                      : contactItem.value
                  }
                  target={contactItem.type === "phone" ? "_self" : "_blank"}
                  rel="noopener noreferrer"
                >
                  {contactItem.type.charAt(0).toUpperCase() +
                    contactItem.type.slice(1)}
                </a>
              )}
            </li>
          ))}
      </ul>
    </footer>
  );
};
