# Dubhacks2024
Local Lifeline - DubHacks 2024 - an ai-powered disaster relief app.

# v1.0
**Backend:**
- Accepts a POST request with a string "message" body, parsing the message using Perplexity.ai and saving it as a Post object (contents: { summary:string, map: <categories:string, tags:string>, urgency:boolean}).
- Accepts a GET request that returns all of the posts made by "seekers" of help.

**Frontend:**
- Accepts input from users classifying their name, location, contact information, and need, and saves it as a Post object (contents: string: input)
- Sends a POST request with the created Post object to be summarized, classified, and tagged for text processing.
- Sends a GET request to accessed saved posts and their associated processed data. Filters Post object based on needs category and displays on GUI.
