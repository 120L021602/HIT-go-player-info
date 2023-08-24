<script>
    import {useStore} from '../stores/store.js'
    import axios from 'axios'
    import { API_PREFIX } from '../api';

    export default{
        
        setup(){
            const store = useStore();
            return {store};

        },

        mounted(){

        },

        data(){
            return{
                input: '',
                inputPw: '',
                inputPw2: '',
                inputName: '',
                inputGender: '',
                inputYearOfBirth: '',
                inputNativePlace: '',
                inputSchool: '',
                inputDepartment: '',
                inputMajor: '',
                inputLevel: '',
                inputYhAccount: '',
                inputComment: '',
                deleteInputName: '',
                deleteInputNativePlace: '',
                queryPlayer: '',
                usernameLogin: '',
                passwordLogin: '',
                usernameChangePw: '',
                oldPw: '',
                newPw: '',
                newPw2: '',
                playerName: '',
                PlayerNativePlace: '',
                playerMatchList: []
            }
        },

        methods:{
            
            //管理员注册
            adminCreate(){
                const username = this.input;
                const password = this.inputPw;
                const password2 = this.inputPw2;
                if(password !== password2){
                    alert("两次输入的密码不一致，请重新输入。");
                    return;
                }
                axios.postForm(API_PREFIX + "/api/admin/create", {
                    username: username,
                    password: password
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("注册成功！");
                        console.log("注册成功！");
                    }
                    else {
                        alert("注册失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //管理员登录
            adminLogin(){
                const username = this.usernameLogin;
                const password = this.passwordLogin;
                axios.postForm(API_PREFIX + "/api/admin/login", {
                    username: username,
                    password: password
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("登录成功！");
                        console.log("登录成功！");
                        this.store.isAdmin = true;
                    }
                    else {
                        alert("登录失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //跳转至管理员修改密码界面
            changePwUi(){
                this.store.type = 'changePw';
            },

            //管理员修改密码
            changePw(){
                const username = this.usernameChangePw;
                const oldPw = this.oldPw;
                const newPw = this.newPw;
                const newPw2 = this.newPw2;
                if(newPw !== newPw2){
                    alert("两次输入密码不一致，请重新输入。");
                    console.log("两次输入密码不一致，请重新输入。");
                    return;
                }
                axios.postForm(API_PREFIX + "/api/admin/change_pw", {
                    username: username,
                    password: oldPw,
                    newPassword: newPw
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("修改成功！");
                        console.log("修改成功！");
                    }
                    else {
                        alert("修改失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //查询棋手信息
            queryPlayerInfo(){
                
                const name = this.queryPlayer;
                axios.postForm(API_PREFIX + "/api/query_player_info", {
                    name: name,
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        console.log("查询成功！");
                        this.store.name = res.data.playerList[0].name;
                        this.store.gender = res.data.playerList[0].gender;
                        this.store.yearOfBirth = res.data.playerList[0].yearOfBirth;
                        this.store.school = res.data.playerList[0].school;
                        this.store.department = res.data.playerList[0].department;
                        this.store.major = res.data.playerList[0].major;
                        this.store.level = res.data.playerList[0].level;
                        this.store.nativePlace = res.data.playerList[0].nativePlace;
                        this.store.comment = res.data.playerList[0].comment;
                        this.store.yhAccount = res.data.playerList[0].yhAccount;

                        this.store.success = true;
                        this.store.type = 'playerInfo';
                    }
                    else {
                        alert("查询失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //删除棋手
            deletePlayer(){
                const name = this.deleteInputName;
                const nativePlace = this.deleteInputNativePlace;
                axios.postForm(API_PREFIX + "/api/delete_player", {
                    name: name,
                    nativePlace: nativePlace
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("删除成功！");
                        console.log("删除成功！");
                    }
                    else {
                        alert("删除失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //添加棋手
            addPlayer(){
                const name = this.inputName;
                const gender = this.inputGender;
                const yearOfBirth = this.inputYearOfBirth;
                const nativePlace = this.inputNativePlace;
                const school = this.inputSchool;
                const department = this.inputDepartment;
                const major = this.inputMajor;
                const level = this.inputLevel;
                const yhAccount = this.inputYhAccount;
                const comment = this.inputComment;
                axios.postForm(API_PREFIX + "/api/add_player", {
                    name: name,
                    gender: gender,
                    yearOfBirth: yearOfBirth,
                    school: school,
                    department: department,
                    major: major,
                    level: level,
                    nativePlace: nativePlace,
                    yhAccount: yhAccount,
                    comment: comment
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("添加成功！");
                        console.log("添加成功！");
                    }
                    else {
                        alert("添加失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //修改棋手信息
            updatePlayer(){
                const name = this.inputName;
                const gender = this.inputGender;
                const yearOfBirth = this.inputYearOfBirth;
                const nativePlace = this.inputNativePlace;
                const school = this.inputSchool;
                const department = this.inputDepartment;
                const major = this.inputMajor;
                const level = this.inputLevel;
                const yhAccount = this.inputYhAccount;
                const comment = this.inputComment;
                axios.postForm(API_PREFIX + "/api/update_player_info", {
                    name: name,
                    gender: gender,
                    yearOfBirth: yearOfBirth,
                    school: school,
                    department: department,
                    major: major,
                    level: level,
                    nativePlace: nativePlace,
                    yhAccount: yhAccount,
                    comment: comment
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        alert("修改成功！");
                        console.log("修改成功！");
                    }
                    else {
                        alert("修改失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            },

            //查询棋手比赛成绩
            queryPlayerMatch(){
                this.playerMatchList = [];
                this.store.type = 'showPlayerMatch';
                const name = this.playerName;
                // const nativePlace = this.PlayerNativePlace;
                axios.postForm(API_PREFIX + "/api/query_player_match", {
                    name: name
                })
                .then(res => {
                    console.log(res);
                    var success = res.data.success;
                    if(success){
                        console.log("查询成功！");
                        const playerMatchList = res.data.playerMatchList;
                        console.log(playerMatchList);
                        for(var i = 0; i < playerMatchList.length; i ++){
                            this.playerMatchList.push({matchName: playerMatchList[i].matchName, 
                            ranking: playerMatchList[i].ranking});
                        }
                        // alert("查询成功！");
                    }
                    else {
                        alert("查询失败！");
                        console.log("Error occurred.");
                    }
                }, err => {
                    console.log(err);
                })
            }
        }
    }
</script>

<template>
    <div id="main">
        <div id="playerInfo" v-show="this.store.type === 'playerInfo'">
            <el-text class="playerInfo" id="name" size="large">姓名：{{ this.store.name}}</el-text>
            <el-text class="playerInfo" id="gender" size="large">性别：{{ this.store.gender }}</el-text>
            <el-text class="playerInfo" id="yearOfBirth" size="large">出生年份：{{ this.store.yearOfBirth }}</el-text>
            <el-text class="playerInfo" id="nativePlace" size="large">籍贯：{{ this.store.nativePlace }}</el-text>
            <el-text class="playerInfo" id="school" size="large">学校：{{ this.store.school }}</el-text>
            <el-text class="playerInfo" id="department" size="large">学院：{{ this.store.department }}</el-text>
            <el-text class="playerInfo" id="major" size="large">专业：{{ this.store.major }}</el-text>
            <el-text class="playerInfo" id="level" size="large">棋力：{{ this.store.level }}</el-text>
            <el-text class="playerInfo" id="yhAccount" size="large">野狐账号：{{ this.store.yhAccount }}</el-text>
        </div>
        
        <div id="adminCreate" v-show="this.store.type === 'adminCreate'">
            <h1 id="adminCreateTitle">管理员注册</h1>
            <input id="username" v-model="input" placeholder="请输入姓名" clearable />
            <input id="password" v-model="inputPw" type="password" placeholder="请输入密码" show-password/>
            <input id="password2" v-model="inputPw2" type="password" placeholder="请再次输入密码" show-password/>
            <el-button class="button" type="info" plain @click="adminCreate">注册</el-button>
        </div>

        <div id="adminLogin" v-show="this.store.type === 'adminLogin'">
            <h1 id="adminLoginTitle">管理员登录</h1>
            <input id="usernameLogin" v-model="usernameLogin" placeholder="请输入姓名" clearable />
            <input id="passwordLogin" v-model="passwordLogin" type="password" placeholder="请输入密码" show-password/>
            <div id="loginAndChangePw">
                <button id="adminLoginSubmit" @click="adminLogin">登录</button>
                <button id="changePwUiSubmit" @click="changePwUi">修改密码</button>
            </div>
        </div>

        <div id="changePw" v-show="this.store.type === 'changePw'">
            <h1>管理员修改密码</h1>
            <input id="usernameChangePw" v-model="usernameChangePw" placeholder="请输入姓名" clearable />
            <input id="oldPw" v-model="oldPw" type="password" placeholder="请输入旧密码" clearable />
            <input id="newPw" v-model="newPw" type="password" placeholder="请输入新密码" clearable />
            <input id="newPw2" v-model="newPw2" type="password" placeholder="请再次输入新密码" clearable />
            <button id="changePwSubmit" @click="changePw">提交</button>
        </div>

        <div id="addPlayer" v-show="this.store.type === 'addPlayer'">
            <h1 id="addPlayerTitle">填写棋手信息</h1>
            <div class="line">
                <span>姓名：</span>
                <input type="text" v-model="inputName">
            </div>
            <div class="line">
                <span>性别：</span>
                <input type="text" v-model="inputGender">
            </div>
            <div class="line">
                <span>出生年份：</span>
                <input type="text" v-model="inputYearOfBirth">
            </div>
            <div class="line">
                <span>籍贯：</span>
                <input type="text" v-model="inputNativePlace">
            </div>
            <div class="line">
                <span>学校：</span>
                <input type="text" v-model="inputSchool">
            </div>
            <div class="line">
                <span>学院：</span>
                <input type="text" v-model="inputDepartment">
            </div>
            <div class="line">
                <span>专业：</span>
                <input type="text" v-model="inputMajor">
            </div>
            <div class="line">
                <span>棋力：</span>
                <input type="text" v-model="inputLevel">
            </div>
            <div class="line">
                <span>野狐账号：</span>
                <input type="text" v-model="inputYhAccount">
            </div>
            <div class="line">
                <span>评价：</span>
                <input type="text" v-model="inputComment" id="comment">
            </div>
            <button id="addPlayerSubmit" @click="addPlayer">提交</button>
        </div>

        <div id="queryPlayer" v-show="this.store.type === 'queryPlayer'">
            <h1>查询棋手信息</h1>
            <div class="line">
                <span>姓名：</span>
                <input type="text" v-model="queryPlayer">
            </div>
            <button id="queryPlayerSubmit" @click="queryPlayerInfo">查询</button>
        </div>

        <div id="deletePlayer" v-show="this.store.type === 'deletePlayer'">
            <h1 id="deletePlayerTitle">删除棋手</h1>
            <div class="line">
                <span>姓名：</span>
                <input type="text" v-model="deleteInputName">
            </div>
            <div class="line">
                <span>籍贯：</span>
                <input type="text" v-model="deleteInputNativePlace">
            </div>
            <button id="deletePlayerSubmit" @click="deletePlayer">提交</button>
        </div>

        <div id="updatePlayer" v-show="this.store.type === 'updatePlayer'">
            <h1 id="updatePlayerTitle">修改棋手信息（仅填写姓名、性别、出生年份和需要修改的字段即可）</h1>
            <div class="line">
                <span>姓名：</span>
                <input type="text" v-model="inputName">
            </div>
            <div class="line">
                <span>性别：</span>
                <input type="text" v-model="inputGender">
            </div>
            <div class="line">
                <span>出生年份：</span>
                <input id="updateYearOfBirth" type="text" v-model="inputYearOfBirth">
            </div>
            <div class="line">
                <span>籍贯：</span>
                <input type="text" v-model="inputNativePlace">
            </div>
            <div class="line">
                <span>学校：</span>
                <input type="text" v-model="inputSchool">
            </div>
            <div class="line">
                <span>学院：</span>
                <input type="text" v-model="inputDepartment">
            </div>
            <div class="line">
                <span>专业：</span>
                <input type="text" v-model="inputMajor">
            </div>
            <div class="line">
                <span>棋力：</span>
                <input type="text" v-model="inputLevel">
            </div>
            <div class="line">
                <span>野狐账号：</span>
                <input type="text" v-model="inputYhAccount">
            </div>
            <div class="line">
                <span>评价：</span>
                <input type="text" v-model="inputComment" id="comment">
            </div>
            <button id="updatePlayerSubmit" @click="updatePlayer">提交</button>
        </div>

        <div id="playerMatch" v-show="this.store.type === 'playerMatch'">
            <h1>查询棋手比赛成绩</h1>
            <div class="line">
                <span>姓名：</span>
                <input type="text" v-model="playerName">
            </div>
            <!-- <div class="line">
                <span>籍贯：</span>
                <input type="text" v-model="PlayerNativePlace">
            </div> -->
            <button id="queryPlayerSubmit" @click="queryPlayerMatch">查询</button>
        </div>

        <div id="showPlayerMatch" v-show="this.store.type === 'showPlayerMatch'">
            <el-table :data="this.playerMatchList" border style="width: 400px">
                <el-table-column prop="matchName" label="比赛名称" width="280px" />
                <el-table-column prop="ranking" label="名次" />
            </el-table>
        </div>

    </div>

   
        
</template>

<style scoped>
    
    #adminCreate{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #adminCreate input{
        width: 500px;
        height: 50px;
        flex-grow: 0;
        /* border-radius: 5px; */
        margin: 5px;
    }

    #adminLogin{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #adminLogin input{
        width: 500px;
        height: 50px;
        flex-grow: 0;
        /* border-radius: 5px; */
        margin: 5px;
    }

    

    #main{

    }

    #adminCreateTitle{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    .button{
        width: 500px;
        height: 50px;
        font-size: large;
    }

    #password2{
        margin-bottom: 30px;
    }

    #playerInfo{
        display: flex;
        flex-direction: column;
    }

    .line span{
        display: inline-block;
        font-size: medium;
        width: 100px;
    }

    .line input{
        height: 20px;
        /* border-radius: 3px; */
    }

    #addPlayerTitle{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 17px;
    }

    #deletePlayerTitle{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    #addPlayer{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    /* #comment{
        width: 300px;
    } */

    #addPlayerSubmit{
        font-size: large;
        margin-top: 20px;
        width: 100%;
        height: 40px;
    }

    #deletePlayerSubmit{
        font-size: large;
        margin-top: 20px;
        width: 100%;
    }

    #deletePlayer{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #queryPlayer h1{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
        /* margin-bottom: 10px; */
    }

    #queryPlayer{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #queryPlayerSubmit{
        font-size: large;
        margin-top: 20px;
        width: 100%;
    }

    #updatePlayerSubmit{
        font-size: large;
        margin-top: 20px;
        width: 80%;
    }

    #updatePlayer{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #updatePlayer h1{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    #adminLoginSubmit{
        font-size: large;
        margin-top: 20px;
        width: 230px;
        height: 55px;
        margin-right: 20px;
    }

    #adminLogin h1{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    #changePwUiSubmit{
        font-size: large;
        margin-top: 20px;
        width: 230px;
        height: 55px;
        margin-left: 20px;
    }

    #loginAndChangePw{
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        justify-content: space-evenly;
    }

    #adminLogin input{
        margin-bottom: 10px;
    }

    #changePw h1{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    #changePwSubmit{
        font-size: large;
        margin-top: 20px;
        width: 97%;
        margin-left: 0;
        height: 45px;
    }

    #changePw{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    #changePw input{
        width: 500px;
        height: 40px;
        /* border-radius: 5px; */
        margin: 7px;
        /* margin-left: 0; */
    }

    #updateYearOfBirth{
        
    }

    .playerInfo{
        width: 200px;
    }

    #playerMatch h1{
        font-weight: bolder;
        font-size: larger;
        margin-bottom: 30px;
    }

    #playerMatch{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
</style>