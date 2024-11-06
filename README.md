# Museo Insight App

[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)]()
[![Maintainer](https://img.shields.io/static/v1?label=Yevhen%20Ruban&message=Maintainer&color=red)](mailto:yevhen.ruban@extrawest.com)
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)]()
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![GitHub release](https://img.shields.io/badge/release-v1.0.0-blue)

Museo Insight is an intelligent virtual museum guide that brings art to life by providing users with rich, contextual information on a wide range of artworks. Built using Java 21, Spring Boot 3.3.3, and LangChain4J, the app seamlessly integrates with the MET Museum's API to allow users to search by department, explore specific works, and view images directly from one of the world’s largest art collections. Through AI-powered analysis, each piece is described in depth, highlighting its historical and cultural significance, visual style, artist background, and year of creation.




https://github.com/user-attachments/assets/1a782a39-e27c-4709-8968-d250f0633e04




## Key Features

- **Comprehensive Art Search and Exploration**: Users can search for artworks across various departments and collections from the MET Museum's vast online database. The app provides access to high-quality images, enabling users to explore the details of each piece closely.
- **AI-Powered Artwork Descriptions**: Leveraging LangChain4J, the AI generates rich, contextual descriptions for each artwork, covering historical background, cultural significance, visual composition, artist biography, and the artwork’s creation year. This feature allows users to gain a deeper understanding and appreciation of each piece.
- **Virtual Museum Guide Experience**: The app functions as a knowledgeable museum guide, curating information and narrating each artwork’s story. It provides users with an immersive experience as they explore each piece with personalized, AI-generated insights.
- **Real-Time Image Analysis and Interpretation**: By analyzing each artwork image, the AI can offer visual insights such as color composition, style, and symbolic elements, helping users understand the artist's technique and message.
- **Dynamic and User-Friendly API**: Designed with intuitive API, users can smoothly browse collections, select pieces of interest, and read detailed descriptions. The UI ensures that each piece of information is easy to access and visually engaging.
- **Educational Resource for Art Enthusiasts and Students**: Museo Insight serves as a valuable resource for art history students, educators, and enthusiasts by providing reliable, well-researched information and deep contextual understanding that enriches learning experiences.

## Tech Stack

- **Java 21**
- **SpringBoot 3.3.3**: Backend framework for building fast and scalable applications.
- **Metmuseum API**: Provides images of artworks.
- **Together AI**: Provides models for describe image. Model: Meta Llama 3.2 90B Vision Instruct Turbo
- **Langchain4j**: Supercharge your Java application with the power of LLMs.

## Running On Local Machine (Linux):

1. Set up the following environment variables.
    - export AI_API_KEY=your_api_key;
2. Run the command: mvn exec:java -Dspring.profiles.active=local
3. Open the following link in your browser: http://localhost:8208/api/swagger-ui/index.html#/

## Contributing

Feel free to open issues or submit pull requests to improve the project. Contributions are welcome!