import { Heart, Handshake, LifeBuoy } from "lucide-react"
import { Button } from "@/components/ui/button"
import Link from "next/link"

export default function SimpleView() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center justify-between p-12 sm:p-16">
      <header className="w-full text-center mb-16">
        <h1 className="text-8xl sm:text-9xl font-bold text-sky-800 mb-6">Relief</h1>
        <p className="text-4xl sm:text-5xl text-sky-600">Connecting hearts, rebuilding lives</p>
      </header>
      
      <main className="flex-grow flex flex-col items-center justify-center w-full max-w-2xl">
        <div className="flex justify-center space-x-16 mb-12">
          <Heart className="w-24 h-24 text-red-500" />
          <Handshake className="w-24 h-24 text-green-500" />
          <LifeBuoy className="w-24 h-24 text-blue-500" />
        </div>
        
        <div className="space-y-8 w-full">
          <Button asChild className="w-full py-8 text-3xl" variant="default">
            <Link href="http://localhost:3000/simpleview/seekhelp_simpleview">Seek Help</Link>
          </Button>
          <Button asChild className="w-full py-8 text-3xl bg-emerald-600 hover:bg-emerald-700 text-white">
            <Link href="/providehelp">Provide Help</Link>
          </Button>
        </div>
      </main>
    </div>
  )
}
