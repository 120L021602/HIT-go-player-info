<script>
    import axios from 'axios'
    import {useStore} from '../stores/store.js'
    import Display from './Display.vue'

    export default{

        components:{
        Display
        },

        setup(){
            const store = useStore();
            return {store};

        },

        mounted(){

        },

        data(){
            return{

            }
        },

        methods:{

        }
    }

</script>

<template>
    <div id="main">
        <Display />
    </div>
</template>

<style scoped>

    #main{
        height: 60vh;
        width: calc(100vw)-180px;
        background-color: #F2F6FC;
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>