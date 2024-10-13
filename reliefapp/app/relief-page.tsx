import { Heart, Handshake, LifeBuoy } from "lucide-react"
import { Button } from "@/components/ui/button"
import Link from "next/link"

export default function ReliefPage() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center justify-between p-4 sm:p-6">
      <header className="w-full text-center mb-8">
        <h1 className="text-5xl sm:text-6xl font-bold text-sky-800 mb-2">LocalLifeline</h1>
        <p className="text-xl text-sky-600">Connecting hearts, rebuilding lives</p>
      </header>
      
      <main className="flex-grow flex flex-col items-center justify-center w-full max-w-md">
        <div className="flex justify-center space-x-8 mb-6">
          <Heart className="w-12 h-12 text-red-500" />
          <Handshake className="w-12 h-12 text-green-500" />
          <LifeBuoy className="w-12 h-12 text-blue-500" />
        </div>
        
        <div className="space-y-4 w-full">
          <Button asChild className="w-full" variant="default">
            <Link href="/seekhelp">Seek Help</Link>
          </Button>
          <Button asChild className="w-full bg-emerald-600 hover:bg-emerald-700 text-white">
            <Link href="/providehelp">Provide Help</Link>
          </Button>
        </div>
      </main>
      
      <footer className="w-full flex justify-end mt-6">
        <Button asChild variant="outline">
          <Link href="/simpleview">Simple View</Link>
        </Button>
      </footer>
    </div>
  )
}