import type { Metadata } from "next";
import "./globals.css";
import { Quicksand } from 'next/font/google'
const quicksand = Quicksand({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: "Relief App",
  description: "Relief app to provide relief.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={quicksand.className}>{children}</body>
    </html>
  );
}
