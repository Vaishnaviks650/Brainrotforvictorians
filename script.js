// Initialize Lucide Icons
lucide.createIcons();

// Sample Brainrot Phrases
const samples = [
    "bro that skibidi toilet video was lowkey fire no cap, the sigma grindset is real fr fr",
    "gyatt that ohio rizz party was bussin ong, we were vibing and taking Ls all night",
    "this mewing tutorial hit different, got that fanum tax energy ngl",
    "im deadass the main character rn, slay queen energy only, mid takes are not allowed",
    "the alpha male just got ratio'd by a beta, W for the underdogs fr"
];

// DOM Elements
const inputText = document.getElementById('inputText');
const randomBtn = document.getElementById('randomBtn');
const charCount = document.getElementById('charCount');
const translateBtn = document.getElementById('translateBtn');
const translateIcon = document.getElementById('translateIcon');
const translateText = document.getElementById('translateText');
const errorMsg = document.getElementById('errorMsg');
const outputText = document.getElementById('outputText');
const outputFooter = document.getElementById('outputFooter');
const copyBtn = document.getElementById('copyBtn');

// Random Example Handler
randomBtn.addEventListener('click', () => {
    const randomIndex = Math.floor(Math.random() * samples.length);
    inputText.value = samples[randomIndex];
    updateCharCount();
});

// Character Counter
const updateCharCount = () => {
    charCount.textContent = `${inputText.value.length} / 1000`;
};
inputText.addEventListener('input', updateCharCount);

// Translate Logic
translateBtn.addEventListener('click', async () => {
    const text = inputText.value.trim();
    if (!text) {
        showError("Please enter some brainrot vernacular first.");
        return;
    }

    // Set Loading State
    translateBtn.disabled = true;
    translateText.textContent = "Formalizing...";
    
    // Swap icon to sparkles and add spin class
    translateIcon.setAttribute('data-lucide', 'sparkles');
    lucide.createIcons(); 
    document.querySelector('#translateBtn svg').classList.add('spin');

    errorMsg.classList.add('hidden');
    outputText.textContent = "The distinguished professor is writing...";
    outputText.classList.add('empty');
    outputFooter.classList.add('hidden');

    try {
        // Send request to our secure Vercel backend
        // (Leaving logic completely untouched as requested)
        const response = await fetch('/api/translate', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ text }) 
        });

        const data = await response.json();

        if (!response.ok) {
            throw new Error(data.error || "A most unfortunate error occurred.");
        }

        // Display Success
        outputText.textContent = data.translation;
        outputText.classList.remove('empty');
        outputFooter.classList.remove('hidden');

    } catch (err) {
        showError(err.message);
        outputText.textContent = "Your distinguished translation shall appear here, dear colleague...";
        outputText.classList.add('empty');
    } finally {
        // Reset Loading State
        translateBtn.disabled = false;
        translateText.textContent = "Make it Distinguished";
        
        // Restore arrow down icon
        translateIcon.setAttribute('data-lucide', 'arrow-down');
        lucide.createIcons();
    }
});

// Copy to Clipboard
copyBtn.addEventListener('click', async () => {
    try {
        await navigator.clipboard.writeText(outputText.textContent);
        
        // Update UI to show copied state
        document.getElementById('copyText').textContent = "Copied!";
        document.getElementById('copyIcon').setAttribute('data-lucide', 'check');
        lucide.createIcons();

        // Reset back to normal after 2 seconds
        setTimeout(() => {
            document.getElementById('copyText').textContent = "Copy";
            document.getElementById('copyIcon').setAttribute('data-lucide', 'copy');
            lucide.createIcons();
        }, 2000);
        
    } catch (err) {
        showError("Failed to copy text.");
    }
});

// Helper for Error Messages
function showError(msg) {
    errorMsg.textContent = msg;
    errorMsg.classList.remove('hidden');
}