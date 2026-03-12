# 🎩 Brainrot to Formal English Translator

**Transform your skibidi sigma rizz into distinguished Victorian prose.**

A quirky, brutalist-style web application that converts contemporary Gen Z internet vernacular ("brainrot") into exquisitely formal, Victorian-era English using AI. 

## 🌟 About the Project

This project bridges the gap between modern internet culture and classical literature. Built with a responsive, brutalist UI aesthetic, it takes chaotic slang and processes it through a highly tuned Large Language Model (LLaMA 3.3 via Groq) acting as a distinguished linguistics professor. 

### ✨ Features
* **AI-Powered Translation:** Accurately translates Gen Z slang into elaborate Victorian prose while maintaining the original context.
* **Brutalist UI Design:** Features a unique, high-contrast aesthetic with hard drop-shadows, bold typography, and a warm cream background.
* **Random Examples:** Don't know what to type? Click "Random Example" to instantly load premium brainrot phrases.
* **Responsive Layout:** Works perfectly on desktop and mobile screens.
* **One-Click Copy:** Easily copy the distinguished output to your clipboard.
* **Secure Backend:** API keys are hidden securely in a Vercel Serverless Function, preventing client-side exposure.
* **Rate Limiting:** Built-in IP-based rate limiting to prevent API abuse.

## 🛠️ Technologies Used

**Frontend:**
* Vanilla HTML5
* Vanilla CSS3 (Custom Brutalist Design System)
* Vanilla JavaScript (ES6+)
* [Lucide Icons](https://lucide.dev/) (via CDN)
* [Geist & Geist Mono Fonts](https://vercel.com/font) (via Google Fonts)

**Backend & AI:**
* Node.js
* Vercel Serverless Functions (`/api` routes)
* [Groq Cloud API](https://groq.com/)
* Model: `llama-3.3-70b-versatile`

## 📂 Project Structure

\`\`\`text
brainrot-translator/
├── package.json        # Project metadata and dependencies
├── index.html          # Main application UI
├── style.css           # Brutalist styles and animations
├── script.js           # Client-side logic and DOM manipulation
└── api/
    └── translate.js    # Secure Vercel serverless function for the Groq API
\`\`\`

## 🚀 Getting Started (Local Development)

To run this project locally, you will need [Node.js](https://nodejs.org/) installed and a free API key from Groq.

### 1. Clone the repository
\`\`\`bash
git clone https://github.com/your-username/brainrot-translator.git
cd brainrot-translator
\`\`\`

### 2. Install dependencies
\`\`\`bash
npm install
\`\`\`

### 3. Set up environment variables
Create a file named `.env` in the root of your project and add your Groq API key:
\`\`\`env
GROQ_API_KEY=your_actual_api_key_here
\`\`\`

### 4. Run with Vercel CLI
Because this project relies on Vercel Serverless Functions for the backend, the best way to run it locally is using the Vercel CLI.

First, install the Vercel CLI globally (if you haven't already):
\`\`\`bash
npm i -g vercel
\`\`\`

Then, start the local development server:
\`\`\`bash
vercel dev
\`\`\`
The app will now be running securely at `http://localhost:3000`.

## 🌐 Deployment

This project is optimized for deployment on [Vercel](https://vercel.com/).

1. Push your code to a GitHub repository.
2. Log in to Vercel and click **Add New -> Project**.
3. Import your GitHub repository.
4. **CRITICAL:** Before clicking deploy, open the **Environment Variables** section. Add a new variable with the key `GROQ_API_KEY` and paste your API key as the value.
5. Click **Deploy**.

## 📝 License

This project is open-source and available under the [MIT License](LICENSE). 
