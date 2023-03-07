<template>
    <div :class="sidebarClass" class="flex flex-col h-full max-w-[277px] bg-slate-800 p-5 relative">
        <!-- <MenuIcon :class="iconMenuClass" @click="openSideBar" class="absolute top-2 rounded-2xl text-xl -right-20 m-2 p-4 bg-slate-500  ease-in-out duration-500 hover:bg-green-600 hover:shadow-[0_0_20px_rgba(0,0,0,0.25)] hover:shadow-green-600"/> -->
        <div class="border-b-2 border-gray-300 text-white flex flex-col w-full">
            <div class="w-full flex items-center justify-evenly">
                <RouterLink to="/admin-profile">
                    <div
                        class="p-1 rounded-full bg-slate-500 mr-2  ease-in-out duration-500 hover:bg-purple-600 hover:shadow-[0_0_20px_rgba(0,0,0,0.25)] hover:shadow-purple-600">
                        <AdminProfile class="text-5xl" />
                    </div>
                </RouterLink>
                <RouterLink to="/admin-profile">
                    <div
                        class="p-2 bg-slate-500 rounded-md ease-in-out duration-500 hover:bg-purple-600 hover:shadow-[0_0_20px_rgba(0,0,0,0.25)] hover:shadow-purple-600">
                        <h3 class="text-center text-xs tracking-widest">I Putu Bayu Gelgel Wiyantara</h3>
                    </div>
                </RouterLink>
                <!-- <BackMenu @click="closeSideBar" class= "text-2xl p-1 px-2 rounded-md ease-in duration-500 bg-slate-500 hover:bg-red-600 hover:shadow-[0_0_20px_rgba(0,0,0,0.25)] hover:shadow-red-600 "/> -->
            </div>
            <h1 class="text-2xl">Admin Perpus Digital</h1>
            <p class="text-xs tracking-widest my-2">SMKN 2 TABANAN</p>
        </div>

        <div class="h-full flex flex-col items-center">
            <div :class="home" class="box-option w-full mt-5 text-white bg-slate-600 p-2 rounded-md">
                <RouterLink to="/" class="w-full flex items-center">
                    <HomeIcon class="text-3xl mr-4" />
                    <h1>Halaman Awal</h1>
                </RouterLink>
            </div>
            <div :class="addBook" class="box-option w-full mt-5 text-white bg-slate-600 p-2 rounded-md">
                <RouterLink to="/add-book" class="w-full flex items-center">
                    <IconAddBook class="text-3xl mr-4" />
                    <h1>Tambah Buku</h1>
                </RouterLink>
            </div>
            <div :class="addPeminjam" class="box-option w-full mt-5 text-white bg-slate-600 p-2 rounded-md">
                <RouterLink to="/add-peminjam" class="flex items-center">
                    <IconAddPeminjam class="text-3xl mr-4" />
                    <h1>Tambah Peminjam</h1>
                </RouterLink>
            </div>
            <div :class="updateBook" class="box-option w-full mt-5 text-white bg-slate-600 p-2 rounded-md">
                <RouterLink to="/update-book" class="flex items-center">
                    <IconEditBuku class="text-3xl mr-4" />
                    <h1>Edit Buku</h1>
                </RouterLink>
            </div>
            <div :class="deleteBook" class="box-option w-full mt-5 text-white bg-slate-600 p-2 rounded-md">
                <RouterLink to="/delete-book" class="flex items-center">
                    <IconDeleteBuku class="text-3xl mr-4" />
                    <h1>Hapus Buku</h1>
                </RouterLink>
            </div>
        </div>
        <Footer class="" />
    </div>
</template>

<script>
import IconAddBook from 'vue-ionicons/dist/ios-add.vue'
import IconAddPeminjam from 'vue-ionicons/dist/md-person-add.vue'
import IconEditBuku from 'vue-ionicons/dist/md-bookmarks.vue'
import IconDeleteBuku from 'vue-ionicons/dist/md-remove.vue'
import Footer from './footer.vue'
import AdminProfile from 'vue-ionicons/dist/md-person.vue'
import SettingAdmin from 'vue-ionicons/dist/md-settings.vue'
import MenuIcon from 'vue-ionicons/dist/md-menu.vue'
import BackMenu from 'vue-ionicons/dist/md-close.vue'
import HomeIcon from 'vue-ionicons/dist/md-home.vue'
import { RouterLink } from 'vue-router'

export default {
    setup() {
        return {
            RouterLink,
        }
    },
    components: {
        IconAddBook,
        IconAddPeminjam,
        IconEditBuku,
        IconDeleteBuku,
        Footer,
        AdminProfile,
        SettingAdmin,
        MenuIcon,
        BackMenu,
        HomeIcon
    },
    data() {
        return {
            isSidebarOpen: true,
            sidebarClass: 'slide-in-left',
            iconMenuClass: 'menu-hidden',
            home: 'not-home',
            addBook: 'not-a-book',
            addPeminjam: 'not-a-peminjam',
            updateBook: 'not-u-peminjam',
            deleteBook: 'not-d-book'
        }
    },
    methods: {
        closeSideBar() {
            this.isSidebarOpen = false
            this.sidebarClass = 'slide-out-left'
            this.iconMenuClass = 'menu-not-hidden'
        },
        openSideBar() {
            this.isSidebarOpen = true;
            this.sidebarClass = 'slide-in-left'
            this.iconMenuClass = 'menu-hidden'
        },
        isHome() {
            this.home = 'home'
        },
        isAddBook() {
            this.addBook = 'a-book'
        },
        isAddPeminjam() {
            this.addPeminjam = 'a-peminjam'
        },
        isUpdateBook() {
            this.updateBook = 'u-update'
        },
        isDeleteBook() {
            this.deleteBook = 'd-book'
        }
    },
    mounted() {
        if(this.$route.fullPath === '/') {
            this.isHome()
        } else if (this.$route.fullPath === '/add-book') {
            this.isAddBook()
        } else if (this.$route.fullPath === '/add-peminjam') {
            this.isAddPeminjam()
        } else if (this.$route.fullPath === '/update-book') {
            this.isUpdateBook()
        } else if(this.$route.fullPath === '/delete-book') {
            this.isDeleteBook()
        }
    }
}

</script>

<style scoped>
.box-option {
    transition: .5s ease-in-out;
}

.box-option:hover {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.home {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.a-book {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.a-peminjam {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.u-update {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.d-book {
    background: #12a2db;
    box-shadow: 0px 0px 20px #12a2db;
}

.slide-in-left {
    animation: slide-in-left .5s ease-in-out forwards;
}

.slide-out-left {
    animation: slide-out-left .5s ease-in-out forwards;
}

@keyframes slide-in-left {
    from {
        transform: translateX(-100%);
    }

    to {
        transform: translateX(0);
    }
}

@keyframes slide-out-left {
    from {
        transform: translateX(0);
    }

    to {
        transform: translateX(-100%);
    }
}

.menu-hidden {
    animation: menu-hidden .5s ease-in-out forwards;
}

.menu-not-hidden {
    animation: menu-not-hidden .5s ease-in-out forwards;
}

@keyframes menu-hidden {
    from {
        opacity: 1;
        display: block;
    }

    to {
        opacity: 0;
        display: none;
    }
}

@keyframes menu-not-hidden {
    form {
        opacity: 0;
        display: none;
    }

    to {
        opacity: 1;
        display: block;
    }
}
</style>