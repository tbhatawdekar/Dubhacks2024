import { Button } from "@/components/ui/button"
import Link from "next/link"
import { 
  Utensils, 
  Home, 
  Droplet, 
  Car, 
  Heart, 
  Dog, 
  Users, 
  Stethoscope 
} from "lucide-react"

export default function NeedsDashboard() {
  const needs = [
    { name: "Food", icon: Utensils, route: "food", color: "bg-amber-500 hover:bg-amber-600" },
    { name: "Shelter", icon: Home, route: "shelter", color: "bg-blue-500 hover:bg-blue-600" },
    { name: "Water", icon: Droplet, route: "water", color: "bg-cyan-500 hover:bg-cyan-600" },
    { name: "Transportation", icon: Car, route: "transportation", color: "bg-green-500 hover:bg-green-600" },
    { name: "Emotional Support", icon: Heart, route: "emotionalsupport", color: "bg-pink-500 hover:bg-pink-600" },
    { name: "Pet Care", icon: Dog, route: "petcare", color: "bg-purple-500 hover:bg-purple-600" },
    { name: "Manpower", icon: Users, route: "manpower", color: "bg-orange-500 hover:bg-orange-600" },
    { name: "Medical", icon: Stethoscope, route: "medical", color: "bg-red-500 hover:bg-red-600" },
  ]

  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center justify-between p-4 sm:p-6">
      <header className="w-full text-center mb-8">
        <h1 className="text-4xl sm:text-5xl font-bold text-sky-800 mb-2">Needs Dashboard</h1>
        <p className="text-xl text-sky-600">Select the type of assistance you need</p>
      </header>
      
      <main className="flex-grow flex flex-col items-center justify-center w-full max-w-4xl">
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4 w-full">
          {needs.map((need) => (
            <Button
              key={need.name}
              asChild
              className={`w-full h-24 ${need.color} text-white font-bold py-2 px-4 rounded-lg transition duration-300 ease-in-out transform hover:scale-105`}
            >
              <Link href={`/providehelp/${need.route}`} className="flex flex-col items-center justify-center">
                <need.icon className="w-8 h-8 mb-2" />
                <span>{need.name}</span>
              </Link>
            </Button>
          ))}
        </div>
      </main>
      
      <footer className="w-full flex justify-between mt-6">
        <Button asChild variant="outline">
          <Link href="/">Back to Home</Link>
        </Button>
        <Button asChild variant="outline">
          <Link href="/simple-view">Simple View</Link>
        </Button>
      </footer>
    </div>
  )
}
