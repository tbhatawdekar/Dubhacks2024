'use client'

import { useEffect, useState } from 'react'
import { Button } from "@/components/ui/button"
import Link from "next/link"
import { AlertTriangle, ChevronDown, ChevronUp, MessageSquare, CheckCircle } from "lucide-react"

interface Post {
  summary: String,
  originalMessage: String,
  categoriesToTags: { [key:string]: Array<String>}
  urgent: boolean;
}

export default function EmotionalSupport() {
  const [posts, setPosts] = useState<Post[]>([]); // State to store the array of posts
  const key = "Shelter";
  useEffect(() => {
      // Make a GET request using fetch
      fetch('http://localhost:8080/provide')
          .then((response) => response.json())  // Convert response to JSON
          .then((data) => {
            const filteredData = data.filter((post: Post) => post.categoriesToTags[key].length > 0);
            setPosts(filteredData);
          })        // Update state with fetched data
          .catch((error) => console.error('Error fetching data:', error));


  }, []); 

  const [expandedPosts, setExpandedPosts] = useState<String[]>([])
  const toggleExpand = (uniqueString: String) => {
    setExpandedPosts(prev => 
        prev.includes(uniqueString) 
            ? prev.filter(postString => postString !== uniqueString)  // Remove if exists
            : [...prev, uniqueString]  // Add if not exists
    );
};

  const handleReply = (originalMessage: String) => {
    // Implement reply functionality
    console.log(`Replying to post ${originalMessage}`)
  }

  const handleFulfill = (originalMessage: String) => {
    // Implement fulfill request functionality
    console.log(`Fulfilling request for post ${originalMessage}`)
  }

  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center p-4 sm:p-6">
      <header className="w-full text-center mb-8">
        <h1 className="text-4xl sm:text-5xl font-bold text-blue-500 hover:text-blue-600 mb-2">
          Shelter Support
        </h1>
        <p className="text-xl text-blue-500 hover:text-blue-600">
          Help out with shelter needs.
        </p>
      </header>

      <main className="w-full max-w-4xl space-y-6">
        {posts === undefined? <p>{"Loading"}</p> : posts.map((post, index) => (
          <div
            key={index}
            className={`bg-white rounded-lg shadow-lg p-6 ${
              post.urgent ? 'border-l-4 border-red-500' : ''
            }`}
          >
            <div className="flex justify-between items-start mb-4">
              <h2 className="text-xl font-semibold text-sky-800">{"Anonymous"}</h2>
              {post.urgent && (
                <div className="flex items-center text-red-500">
                  <AlertTriangle className="w-5 h-5 mr-1" />
                  <span className="text-sm font-medium">Urgent</span>
                </div>
              )}
            </div>
            <p className="text-gray-600 mb-4">
              {post.summary}
            </p>
            {expandedPosts.includes(post.originalMessage) && (
              <div className="mb-4 text-sm text-gray-500">
                <p>{post.originalMessage}</p>
              </div>
            )}
            <div className="flex flex-wrap gap-2 mb-4">
              {post.categoriesToTags[key].map((tag, index) => (
                <span
                  key={index}
                  className="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-sky-100 text-sky-800"
                >
                  {tag}
                </span>
              
              ))}
            </div>
            <div className="flex justify-between items-center">
              <div className="space-x-2">
                <Button onClick={() => handleReply(post.originalMessage)} variant="outline" size="sm">
                  <MessageSquare className="w-4 h-4 mr-1" />
                  Reply
                </Button>
                <Button onClick={() => handleFulfill(post.originalMessage)} variant="outline" size="sm">
                  <CheckCircle className="w-4 h-4 mr-1" />
                  Fulfill Request
                </Button>
              </div>
              <Button onClick={() => toggleExpand(post.originalMessage)} variant="ghost" size="sm">
                {expandedPosts.includes(post.originalMessage) ? (
                  <ChevronUp className="w-4 h-4" />
                ) : (
                  <ChevronDown className="w-4 h-4" />
                )}
              </Button>
            </div>
          </div>
        ))}
      </main>

      <footer className="w-full flex justify-start mt-6">
        <Button asChild variant="outline">
          <Link href="/providehelp">Back to Provide Help</Link>
        </Button>
      </footer>
    </div>
  )
}