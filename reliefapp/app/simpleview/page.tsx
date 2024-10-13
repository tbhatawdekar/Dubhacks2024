import { Heart, Handshake, LifeBuoy } from "lucide-react"
import { Button } from "@/components/ui/button"
import Link from "next/link"

export default function SimpleView() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-sky-100 to-sky-50 flex flex-col items-center justify-between p-12 sm:p-16">
      <header className="w-full text-center mb-16">
        <h1 className="text-8xl sm:text-9xl font-bold text-sky-800 mb-6">Relief</h1>
      </header>
      <main className="flex-grow flex flex-col items-center justify-center w-full max-w-2xl">
        <div className="space-y-8 w-full">
          <Button asChild className="w-full py-16 text-5xl" variant="default">
            <Link href="http://localhost:3000/simpleview/seekhelp_simpleview">Seek Help</Link>
          </Button>
          <Button asChild className="w-full py-16 text-5xl bg-emerald-600 hover:bg-emerald-700 text-white">
            <Link href="/providehelp">Provide Help</Link>
          </Button>
        </div>
      </main>
    </div>
  )
}
