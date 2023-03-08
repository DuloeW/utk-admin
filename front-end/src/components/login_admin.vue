<template>
    <div class="w-full h-screen flex justify-between items-center">
        <div class="w-2/4 h-full grid place-items-center">
            <div class="w-96 h-2/3 shadow-2xl rounded-2xl p-5">
                <h1 class="font-bold text-3xl text-center tracking-widest">Login</h1>
                <form class="w-full h-5/6 mt-4 flex flex-col gap-4">
                    <div class="input-data">
                        <label for="">Email</label>
                        <input type="text">
                    </div>
                    <div class="input-data">
                        <label for="">Password</label>
                        <input type="text">
                    </div>
                    <div class="input-data">
                        <label for="">Kode</label>
                        <input type="text">
                    </div>
                    <input type="submit" value="Kirim" class="bg-blue-700 py-3 w-2/5 self-center mt-5 rounded-xl text-white font-bold tracking-widest">
                </form>
            </div>
        </div>
        <div class="w-2/4 h-full relative grid place-items-center">
            <div class="mark absolute right-0 top-0 bg-blue-700 w-72 h-[500px]">

            </div>
            <PersonInLeftSide class="z-[1] mt-32"/>
        </div>
    </div>
</template>
<script>
import PersonInLeftSide from './icons/stuck_at_home_brainstorming.vue';
export default {
    data() {
        return {

        }
    },
    components: {
        PersonInLeftSide
    }
}
</script>
<style scoped>

.input-data {
    display: flex;
    flex-direction: column;
}

.input-data input {
    background: #fff;
    padding: 10px;
    border-radius: 5px;
    box-shadow: 0px 10px 20px #e9e9e9;
}

.input-data label {
    font-size: 18px;
    letter-spacing: 2px;
    color: #2e2e2e;
}

.mark {
    border-bottom-left-radius: 100px;
}

</style>