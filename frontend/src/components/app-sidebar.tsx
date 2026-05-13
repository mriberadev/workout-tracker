import {
    Sidebar,
    SidebarContent,
    SidebarFooter,
    SidebarGroup,
    SidebarHeader, SidebarMenu, SidebarMenuButton,
    SidebarMenuItem,
} from "@/components/ui/sidebar"
import { House } from "lucide-react";

export function AppSidebar() {

    const navMain = [
        {
            title: "Home",
            url: "/",
            icon: House,
        },
        {
            title: "Home",
            url: "/",
            icon: House,
        },
        {
            title: "Home",
            url: "/",
            icon: House,
        },
    ];

    return (
        <Sidebar>
            <SidebarHeader/>
            <SidebarContent>
                <SidebarGroup>
                    <SidebarMenu>
                        {navMain.map((item) => (
                            <SidebarMenuItem>
                                <SidebarMenuButton render= {<a href="item.url" />} >
                                    <item.icon />{item.title}
                                </SidebarMenuButton>
                            </SidebarMenuItem>
                        ))}
                    </SidebarMenu>
                </SidebarGroup>
                <SidebarGroup/>
            </SidebarContent>
            <SidebarFooter/>
        </Sidebar>
    )
}