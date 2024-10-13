# Local Lifeline - Dubhacks2024 - an ai-powered disaster relief app.

# v1.0
**Backend:**
- Accepts a POST request with a string "message" body, parsing the message using Perplexity.ai and saving it as a Post object (contents: { summary:string, map: <categories:string, tags:string>, urgency:boolean}).
- Accepts a GET request that returns all of the posts made by "seekers" of help.

**Frontend:**
- Accepts input from users classifying their name, location, contact information, and need, and saves it as a Post object (contents: string: input)
- Sends a POST request with the created Post object to be summarized, classified, and tagged for text processing.
- Sends a GET request to accessed saved posts and their associated processed data. Filters Post object based on needs category and displays on GUI.

# About:
## Inspiration
As we’ve seen in recent catastrophes, natural disasters are becoming more frequent and destructive, leaving communities to grapple with the aftermath. While our governments have worked to install more and more robust disaster relief systems, Hurricane Milton & Helene served as a stark reminder of how easily emergency services can become overwhelmed. Without external help, we can only turn to our communities to step up and support one other. 

The elderly, in particular, are often the most vulnerable during such crises. Many face mobility challenges, lack transportation, or live in isolation, making evacuation and receiving aid difficult. Furthermore, their lack of experience with technology makes it difficult for them to find resources online. Inspired by the resilience of Florida communities during Hurricane Milton, we created **Local Lifeline**—a platform designed to connect those in need with nearby volunteers during emergencies, ensuring everyone gets the help they need.

## What it does
**Local Lifeline** is a web application designed to connect elderly individuals in need during natural disasters with local volunteers who can provide assistance. To simplify the request steps, users can discuss their current needs in a single text block — such as food, shelter, or medical care - which is then parsed into categories using Perplexity.ai API. Individuals in the area with the capabilities to assist can then fulfill aid requests by navigating through our categorized aid dashboard. These categories, ranging from emotional support to transportation to medical assistance, feature 8 key areas in which elderly individuals would need aid in a crisis. And as many elderly individuals often struggle with technology, **Local Lifeline** prioritizes accessibility, featuring an optional simplified interface option and voice input, ensuring that elderly users can easily communicate their needs and receive timely help from their community.

## How we built it
**Local Lifeline** was developed as a responsive, user-friendly web application using React.js, Next.js, typescript, Java, and Spring Boot with a focus on clear, simple design. Accessibility was a priority, leading to features such as a "simple view" mode with larger text and fewer visuals, voice input support for users to easily communicate their requests, and form assistance to guide elderly users in filling out their posts. Additionally, an integrated large language model (LLM) by Perplexity.ai processes user-submitted posts, categorizing them and tagging them with appropriate keywords. This automated system ensures that volunteers can quickly find requests that match their skills and availability, making the platform efficient and effective.

## Challenges we ran into
The journey to build **Local Lifeline** came with several challenges:  
1. **Balancing Simplicity and Functionality:** Creating a platform that was both easy to use for elderly individuals and robust enough to handle complex data and requests was a delicate balancing act. We considered customer needs and limiting factors in UI interaction to strike a fine line between simple and complex.
2. **Training the LLM:** The LLM initially struggled with parsing certain requests accurately, leading to misclassifications that required fine-tuning and adjustment. We tried a handful of prompts and checked against dozens of mock-inputs to properly calibrate the LLM’s response.

## Accomplishments
We take great pride in developing a functional prototype within such a short timeframe. Despite starting with minimal knowledge of APIs and their implementation, we successfully integrated the Perplexity APIs into our project. This achievement allowed us to create an automated system leveraging Perplexity's large language model, enabling real-time categorization of user aid requests. We're thrilled that this innovative solution enhances the efficiency of our platform, ensuring that help can be quickly and effectively matched to those in need.

## What we learned
We learned to effectively utilize the front-end framework React.js, which allowed us to simplify our development process by integrating logic and user interface components seamlessly. We also explored Next.js for server-side rendering and routing, enhancing our application's performance and user experience. On the back end, we gained comprehensive knowledge of implementing APIs and working with LLM API responses using Java and Spring Boot. We explored critical concepts such as obtaining authentication tokens, avoiding CORS errors, and using Postman for testing our GET and POST requests. Additionally, we learned to proxy and query our APIs effectively. Collaboration was another key learning area; our hourly group check-ins fostered effective communication, allowing us to discuss our objectives, celebrate our accomplishments, and outline our next steps while keeping our energy up. Who knew that the best way to improve focus would be to take a 5-minute walk with your teammates?

## What's next for Local Lifeline
Looking ahead, we are excited to enhance Local Lifeline with several key features. We would introduce an "All Posts" view, allowing users to access all requests in one place, making it easier for volunteers to identify needs within the community and provide assistance quickly. We plan to integrate real-time climate updates and emergency alerts to keep users informed about potential disasters, empowering elderly individuals to stay aware of their surroundings and take necessary precautions. Additionally, we aim to implement a status check feature that includes a scrolling percentage bar, giving users transparency about the progress of their requests and fostering a sense of assurance as they wait for assistance. To ensure data persistence, we will establish a robust database that securely stores user information and request histories. By focusing on these enhancements, we strive to create a more robust and impactful resource for disaster relief efforts in our community.

