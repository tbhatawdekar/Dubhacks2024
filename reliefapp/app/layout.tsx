import './globals.css'
import type { Metadata } from 'next'

export const metadata: Metadata = {
  title: 'Hurricane Relief',
  description: 'Connecting hearts, rebuilding lives',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  )
}