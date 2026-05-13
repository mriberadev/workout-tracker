import Header from "@/components/Header.tsx";
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar"
import { AppSidebar } from "@/components/app-sidebar"

type Props = {
    children: React.ReactNode;
};

const Layout = ({children}: Props) => {
    return (
        <SidebarProvider>
            <AppSidebar />
            <main>
                <SidebarTrigger />

                <div className="flex flex-col min-h-screen px-10">
                    <Header/>

                    <div className="container mx-auto flex-1 py-10">{children}</div>
                </div>
            </main>
        </SidebarProvider>
    );
};

export default Layout;