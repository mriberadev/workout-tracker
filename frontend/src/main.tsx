import {StrictMode} from "react"
import {createRoot} from "react-dom/client"
import {BrowserRouter as Router} from "react-router-dom";

import "./index.css"
import {ThemeProvider} from "@/components/theme-provider.tsx"
import AppRoutes from "@/AppRoutes.tsx";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <ThemeProvider>
            <Router>
                <AppRoutes/>
            </Router>
        </ThemeProvider>
    </StrictMode>
)
