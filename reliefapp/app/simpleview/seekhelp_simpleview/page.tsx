import { Button } from "@/components/ui/button"
import { Checkbox } from "@/components/ui/checkbox"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"
import { AlertTriangle, Mic, HelpCircle } from "lucide-react"
import Link from "next/link"

export default function SeekHelp() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center p-8 sm:p-12">
      <header className="w-full text-center mb-12">
        <h1 className="text-6xl sm:text-7xl font-bold text-sky-800 mb-4">Make A Request</h1>
        <p className="text-2xl text-sky-600">We're here to help you through this difficult time</p>
      </header>

      <main className="w-full max-w-3xl bg-white rounded-lg shadow-lg p-10 space-y-8">
        <div className="flex items-center justify-center space-x-3 text-amber-600 mb-6">
          <AlertTriangle className="w-10 h-10" />
          <span className="text-2xl font-semibold">Emergency Request Form</span>
        </div>

        <form className="space-y-6">
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
            <Input placeholder="Your Name" className="text-xl py-4" required />
            <Input placeholder="Location" className="text-xl py-4" required />
            <Input type="tel" placeholder="Phone Number" className="text-xl py-4" required />
            <Input type="email" placeholder="Email Address" className="text-xl py-4" required />
          </div>

          <div className="relative">
            <Textarea 
              placeholder="I need help with __. I am experiencing these medical issues: ___. I need help in ___ hours." 
              className="min-h-[200px] text-xl py-4 pr-12"
              required
            />
            <Mic className="absolute right-4 top-4 w-8 h-8 text-sky-600 cursor-pointer" />
          </div>

          <div className="flex items-center space-x-4">
            <Checkbox id="mobility" className="w-6 h-6" />
            <label htmlFor="mobility" className="text-lg font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
              I have mobility issues
            </label>
          </div>

          <div className="flex justify-between items-center">
            <Button type="submit" className="text-2xl py-4 px-8 bg-red-600 hover:bg-red-700 text-white">
              Submit Request
            </Button>
            <Button variant="outline" className="flex items-center space-x-4 py-4 px-6 text-xl">
              <HelpCircle className="w-6 h-6" />
              <span>Step-by-Step Form</span>
            </Button>
          </div>
        </form>
      </main>

      <footer className="w-full flex justify-between mt-8">
        <Button asChild variant="outline" className="text-xl py-4 px-8">
          <Link href="/">Back to Home</Link>
        </Button>
      </footer>
    </div>
  )
}
