'use client'

import { useState } from 'react'
import { Button } from "@/components/ui/button"
import Link from "next/link"
import { AlertTriangle, ChevronDown, ChevronUp, MessageSquare, CheckCircle } from "lucide-react"

// Mock data for demonstration purposes
const mockPosts = [
  {
    id: 1,
    name: "John Doe",
    summary: "Need help with food and water. Mobility issues.",
    message: "I need help with food and water. I am experiencing difficulty moving around. I need help in 24 hours. I'm located in the downtown area and can't access the local grocery store due to flooding.",
    location: "123 Main St, Anytown, USA",
    phone: "555-123-4567",
    email: "john.doe@example.com",
    tags: ["food", "water", "mobility"],
    urgent: true,
  },
  {
    id: 2,
    name: "Jane Smith",
    summary: "Assistance needed with groceries due to flooding.",
    message: "Looking for assistance with groceries. I can't leave my house due to the flooding. Any help is appreciated. I have a list of essential items that I need.",
    location: "456 Elm St, Anytown, USA",
    phone: "555-987-6543",
    email: "jane.smith@example.com",
    tags: ["food", "manpower"],
    urgent: false,
  },
  {
    id: 3,
    name: "Robert Johnson",
    summary: "Need transportation to grocery store. Low on supplies.",
    message: "Need help getting to the grocery store. My car is out of gas and I'm running low on supplies. I can pay for gas if someone can give me a ride.",
    location: "789 Oak St, Anytown, USA",
    phone: "555-246-8135",
    email: "robert.johnson@example.com",
    tags: ["food", "gasoline", "transportation"],
    urgent: true,
  },
]


export default function EmotionalSupport() {
  const [posts, setPosts] = useState(mockPosts)
  const [expandedPosts, setExpandedPosts] = useState<number[]>([])

  const toggleExpand = (id: number) => {
    setExpandedPosts(prev => 
      prev.includes(id) ? prev.filter(postId => postId !== id) : [...prev, id]
    )
  }

  const handleReply = (id: number) => {
    // Implement reply functionality
    console.log(`Replying to post ${id}`)
  }

  const handleFulfill = (id: number) => {
    // Implement fulfill request functionality
    console.log(`Fulfilling request for post ${id}`)
  }

  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center p-4 sm:p-6">
      <header className="w-full text-center mb-8">
      <h1 className="text-4xl sm:text-5xl font-bold text-red-500 hover:text-red-600 mb-2">
        Medical Support
      </h1>
      <p className="text-xl text-red-500 hover:text-red-600">
        Help out with medical needs.
      </p>
    </header>

      <main className="w-full max-w-4xl space-y-6">
        {posts.map((post) => (
          <div
            key={post.id}
            className={`bg-white rounded-lg shadow-lg p-6 ${
              post.urgent ? 'border-l-4 border-red-500' : ''
            }`}
          >
            <div className="flex justify-between items-start mb-4">
              <h2 className="text-xl font-semibold text-sky-800">{post.name}</h2>
              {post.urgent && (
                <div className="flex items-center text-red-500">
                  <AlertTriangle className="w-5 h-5 mr-1" />
                  <span className="text-sm font-medium">Urgent</span>
                </div>
              )}
            </div>
            <p className="text-gray-600 mb-4">
              {expandedPosts.includes(post.id) ? post.message : post.summary}
            </p>
            {expandedPosts.includes(post.id) && (
              <div className="mb-4 text-sm text-gray-500">
                <p>Location: {post.location}</p>
                <p>Phone: {post.phone}</p>
                <p>Email: {post.email}</p>
              </div>
            )}
            <div className="flex flex-wrap gap-2 mb-4">
              {post.tags.map((tag) => (
                <span
                  key={tag}
                  className="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-sky-100 text-sky-800"
                >
                  {tag}
                </span>
              
              ))}
            </div>
            <div className="flex justify-between items-center">
              <div className="space-x-2">
                <Button onClick={() => handleReply(post.id)} variant="outline" size="sm">
                  <MessageSquare className="w-4 h-4 mr-1" />
                  Reply
                </Button>
                <Button onClick={() => handleFulfill(post.id)} variant="outline" size="sm">
                  <CheckCircle className="w-4 h-4 mr-1" />
                  Fulfill Request
                </Button>
              </div>
              <Button onClick={() => toggleExpand(post.id)} variant="ghost" size="sm">
                {expandedPosts.includes(post.id) ? (
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