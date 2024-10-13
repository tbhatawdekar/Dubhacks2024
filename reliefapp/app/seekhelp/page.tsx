import { Button } from "@/components/ui/button"
import { Checkbox } from "@/components/ui/checkbox"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"
import { AlertTriangle, Mic, HelpCircle } from "lucide-react"
import Link from "next/link"

export default function SeekHelp() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center p-4 sm:p-6">
      <header className="w-full text-center mb-8">
        <h1 className="text-4xl sm:text-5xl font-bold text-sky-800 mb-2">Make A Request</h1>
        <p className="text-lg text-sky-600">We're here to help you through this difficult time</p>
      </header>

      <main className="w-full max-w-2xl bg-white rounded-lg shadow-lg p-6 space-y-6">
        <div className="flex items-center justify-center space-x-2 text-amber-600 mb-4">
          <AlertTriangle className="w-6 h-6" />
          <span className="font-semibold">Emergency Request Form</span>
        </div>

        <form className="space-y-4">
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
            <Input placeholder="Your Name" required />
            <Input placeholder="Location" required />
            <Input type="tel" placeholder="Phone Number" required />
            <Input type="email" placeholder="Email Address" required />
          </div>

          <div className="relative">
            <Textarea 
              placeholder="I need help with __. I am experiencing these medical issues: ___. I need help in ___ hours." 
              className="min-h-[150px] pr-10"
              required
            />
            <Mic className="absolute right-3 top-3 w-5 h-5 text-sky-600 cursor-pointer" />
          </div>

          <div className="flex items-center space-x-2">
            <Checkbox id="mobility" />
            <label htmlFor="mobility" className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
              I have mobility issues
            </label>
          </div>

          <div className="flex justify-between items-center">
            <Button type="submit" className="bg-red-600 hover:bg-red-700 text-white">
              Submit Request
            </Button>
            <Button variant="outline" className="flex items-center space-x-2">
              <HelpCircle className="w-4 h-4" />
              <span>Step-by-Step Form</span>
            </Button>
          </div>
        </form>
      </main>

      <footer className="w-full flex justify-between mt-6">
        <Button asChild variant="outline">
          <Link href="/">Back to Home</Link>
        </Button>
      </footer>
    </div>
  )
}