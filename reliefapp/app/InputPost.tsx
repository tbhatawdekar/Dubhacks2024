import React from "react";
import axios from "axios";

interface RequestBody {
    message: string;
}
interface InputPostProps {
    textInput: string;
}

const InputPost = ({ textInput } : InputPostProps) => {
    const backendUrl = "http://localhost:8080";

    const handleSubmit = async (event: React.FormEvent) => {
        // event.preventDefault(); // Prevent the default form submission

        const body: RequestBody = {
            message: textInput,
            // Add more fields to the body if necessary
        };

        try {
            const response = await axios.post(backendUrl+"/seek", body);
            console.log('Response:', response.data);
        } catch (error) {
            console.error('Error submitting data:', error);
        }
    };

    return { handleSubmit };
}

export default InputPost;