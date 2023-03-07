<template>
    <div class="flex flex-col justify-around items-center  w-44 h-36 rounded-lg text-white">
        <font-awesome-icon icon="phone" class="text-3xl"/>
        <div>
            <h2 class="font-semibold tracking-widest text-center">{{ message }}</h2>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        message: String
    }
}
</script>