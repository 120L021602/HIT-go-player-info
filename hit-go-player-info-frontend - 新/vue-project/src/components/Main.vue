<script>
import { useStore } from "../stores/store.js";
import axios from "axios";
import { API_PREFIX } from "../api";
import { useTranslationStore } from "../stores/translation";
import { storeToRefs } from "pinia";

export default {
  setup() {
    const store = useStore();
    const { t } = storeToRefs(useTranslationStore());
    return { store, t };
  },

  mounted() {},

  data() {
    return {
      input: "",
      inputPw: "",
      inputPw2: "",
      inputName: "",
      inputGender: "",
      inputYearOfBirth: "",
      inputNativePlace: "",
      inputSchool: "",
      inputDepartment: "",
      inputMajor: "",
      inputLevel: "",
      inputYhAccount: "",
      inputComment: "",
      deleteInputName: "",
      deleteInputNativePlace: "",
      queryPlayer: "",
      usernameLogin: "",
      passwordLogin: "",
      usernameChangePw: "",
      oldPw: "",
      newPw: "",
      newPw2: "",
      playerName: "",
      PlayerNativePlace: "",
      playerMatchList: []
    };
  },

  methods: {
    //管理员注册
    adminCreate() {
      const username = this.input;
      const password = this.inputPw;
      const password2 = this.inputPw2;
      if (password !== password2) {
        alert(this.t.passwordsDisagree);
        return;
      }
      axios
        .postForm(API_PREFIX + "/api/admin/create", {
          username: username,
          password: password
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.createSuccess);
              console.log(this.t.createSuccess);
            } else {
              alert(this.t.createFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //管理员登录
    adminLogin() {
      const username = this.usernameLogin;
      const password = this.passwordLogin;
      axios
        .postForm(API_PREFIX + "/api/admin/login", {
          username: username,
          password: password
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.loginSuccess);
              console.log(this.t.loginSuccess);
              this.store.isAdmin = true;
            } else {
              alert(this.t.loginFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //跳转至管理员修改密码界面
    changePwUi() {
      this.store.type = "changePw";
    },

    //管理员修改密码
    changePw() {
      const username = this.usernameChangePw;
      const oldPw = this.oldPw;
      const newPw = this.newPw;
      const newPw2 = this.newPw2;
      if (newPw !== newPw2) {
        alert(this.t.passwordsDisagree);
        console.log(this.t.passwordsDisagree);
        return;
      }
      axios
        .postForm(API_PREFIX + "/api/admin/change_pw", {
          username: username,
          password: oldPw,
          newPassword: newPw
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.updateSuccess);
              console.log(this.t.updateSuccess);
            } else {
              alert(this.t.updateFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //查询棋手信息
    queryPlayerInfo() {
      const name = this.queryPlayer;
      axios
        .postForm(API_PREFIX + "/api/query_player_info", {
          name: name
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              console.log(this.t.querySuccess);
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
              this.store.type = "playerInfo";
            } else {
              alert(this.t.queryFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //删除棋手
    deletePlayer() {
      const name = this.deleteInputName;
      const nativePlace = this.deleteInputNativePlace;
      axios
        .postForm(API_PREFIX + "/api/delete_player", {
          name: name,
          nativePlace: nativePlace
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.deleteSuccess);
              console.log(this.t.deleteSuccess);
            } else {
              alert(this.t.deleteFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //添加棋手
    addPlayer() {
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
      axios
        .postForm(API_PREFIX + "/api/add_player", {
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
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.addSuccess);
              console.log(this.t.addSuccess);
            } else {
              alert(this.t.addFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //修改棋手信息
    updatePlayer() {
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
      axios
        .postForm(API_PREFIX + "/api/update_player_info", {
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
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              alert(this.t.updateSuccess);
              console.log(this.t.updateSuccess);
            } else {
              alert(this.t.updateFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    },

    //查询棋手比赛成绩
    queryPlayerMatch() {
      this.playerMatchList = [];
      this.store.type = "showPlayerMatch";
      const name = this.playerName;
      // const nativePlace = this.PlayerNativePlace;
      axios
        .postForm(API_PREFIX + "/api/query_player_match", {
          name: name
        })
        .then(
          (res) => {
            console.log(res);
            var success = res.data.success;
            if (success) {
              console.log(this.t.querySuccess);
              const playerMatchList = res.data.playerMatchList;
              console.log(playerMatchList);
              for (var i = 0; i < playerMatchList.length; i++) {
                this.playerMatchList.push({
                  matchName: playerMatchList[i].matchName,
                  ranking: playerMatchList[i].ranking
                });
              }
              // alert("查询成功！");
            } else {
              alert(this.t.queryFailure);
              console.log("Error occurred.");
            }
          },
          (err) => {
            console.log(err);
          }
        );
    }
  }
};
</script>

<template>
  <div class="content-wrapper">
    <div v-show="this.store.type === 'playerInfo'">
      <el-table :data="store.infoList" border>
        <el-table-column :label="t.information" width="150px">
          <template #default="scope">
            {{ t[scope.row.info] }}
          </template>
        </el-table-column>
        <el-table-column prop="detail" :label="t.detail" width="250px" />
      </el-table>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'adminCreate'">
      <h1>{{ t.adminCreate }}</h1>
      <el-input class="form-input" v-model="input" :placeholder="t.enterName" clearable />
      <el-input
        class="form-input"
        v-model="inputPw"
        type="password"
        :placeholder="t.enterPassword"
        show-password
      />
      <el-input
        class="form-input"
        v-model="inputPw2"
        type="password"
        :placeholder="t.enterPasswordAgain"
        show-password
      />
      <el-button class="button-stretch" type="primary" round @click="adminCreate">{{
        t.create
      }}</el-button>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'adminLogin'">
      <h1>{{ t.adminLogin }}</h1>
      <el-input class="form-input" v-model="usernameLogin" :placeholder="t.enterName" clearable />
      <el-input
        class="form-input"
        v-model="passwordLogin"
        type="password"
        :placeholder="t.enterPassword"
        show-password
      />
      <div class="admin-login-buttons">
        <el-button class="button-admin-login" type="primary" round @click="adminLogin">{{
          t.login
        }}</el-button>
        <el-button class="button-admin-login" type="primary" round @click="changePwUi">{{
          t.changePw
        }}</el-button>
      </div>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'changePw'">
      <h1>{{ t.adminChangePw }}</h1>
      <el-input
        class="form-input"
        v-model="usernameChangePw"
        :placeholder="t.enterName"
        clearable
      />
      <el-input
        class="form-input"
        v-model="oldPw"
        type="password"
        :placeholder="t.enterOldPw"
        clearable
      />
      <el-input
        class="form-input"
        v-model="newPw"
        type="password"
        :placeholder="t.enterNewPw"
        clearable
      />
      <el-input
        class="form-input"
        v-model="newPw2"
        type="password"
        :placeholder="t.enterNewPwAgain"
        clearable
      />
      <el-button class="button-stretch" type="primary" round @click="changePw">{{
        t.submit
      }}</el-button>
    </div>

    <div class="form-wrapper form-wrapper-compact" v-show="this.store.type === 'addPlayer'">
      <h1>{{ t.fillPlayerInfo }}</h1>
      <div class="line">
        <span>{{ t.name }}</span>
        <el-input class="form-input-small" type="text" v-model="inputName" />
      </div>
      <div class="line">
        <span>{{ t.gender }}</span>
        <el-input class="form-input-small" type="text" v-model="inputGender" />
      </div>
      <div class="line">
        <span>{{ t.yearOfBirth }}</span>
        <el-input class="form-input-small" type="text" v-model="inputYearOfBirth" />
      </div>
      <div class="line">
        <span>{{ t.nativePlace }}</span>
        <el-input class="form-input-small" type="text" v-model="inputNativePlace" />
      </div>
      <div class="line">
        <span>{{ t.school }}</span>
        <el-input class="form-input-small" type="text" v-model="inputSchool" />
      </div>
      <div class="line">
        <span>{{ t.department }}</span>
        <el-input class="form-input-small" type="text" v-model="inputDepartment" />
      </div>
      <div class="line">
        <span>{{ t.major }}</span>
        <el-input class="form-input-small" type="text" v-model="inputMajor" />
      </div>
      <div class="line">
        <span>{{ t.level }}</span>
        <el-input class="form-input-small" type="text" v-model="inputLevel" />
      </div>
      <div class="line">
        <span>{{ t.yhAccount }}</span>
        <el-input class="form-input-small" type="text" v-model="inputYhAccount" />
      </div>
      <div class="line">
        <span>{{ t.comment }}</span>
        <el-input class="form-input-small" type="text" v-model="inputComment" />
      </div>
      <el-button class="button-half-stretch" type="primary" round @click="addPlayer">{{
        t.submit
      }}</el-button>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'queryPlayer'">
      <h1>{{ t.queryPlayer }}</h1>
      <div class="line">
        <span>{{ t.name }}</span>
        <el-input class="form-input" type="text" v-model="queryPlayer" />
      </div>
      <el-button class="button-half-stretch" type="primary" round @click="queryPlayerInfo">{{
        t.query
      }}</el-button>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'deletePlayer'">
      <h1>{{ t.deletePlayer }}</h1>
      <div class="line">
        <span>{{ t.name }}</span>
        <el-input class="form-input" type="text" v-model="deleteInputName" />
      </div>
      <div class="line">
        <span>{{ t.nativePlace }}</span>
        <el-input class="form-input" type="text" v-model="deleteInputNativePlace" />
      </div>
      <el-button class="button-half-stretch" type="primary" round @click="deletePlayer">{{
        t.submit
      }}</el-button>
    </div>

    <div class="form-wrapper form-wrapper-compact" v-show="this.store.type === 'updatePlayer'">
      <h1 style="white-space: pre">{{ t.updatePlayerInfoHint }}</h1>
      <div class="line">
        <span>{{ t.name }}</span>
        <el-input class="form-input-small" type="text" v-model="inputName" />
      </div>
      <div class="line">
        <span>{{ t.gender }}</span>
        <el-input class="form-input-small" type="text" v-model="inputGender" />
      </div>
      <div class="line">
        <span>{{ t.yearOfBirth }}</span>
        <el-input class="form-input-small" type="text" v-model="inputYearOfBirth" />
      </div>
      <div class="line">
        <span>{{ t.nativePlace }}</span>
        <el-input class="form-input-small" type="text" v-model="inputNativePlace" />
      </div>
      <div class="line">
        <span>{{ t.school }}</span>
        <el-input class="form-input-small" type="text" v-model="inputSchool" />
      </div>
      <div class="line">
        <span>{{ t.department }}</span>
        <el-input class="form-input-small" type="text" v-model="inputDepartment" />
      </div>
      <div class="line">
        <span>{{ t.major }}</span>
        <el-input class="form-input-small" type="text" v-model="inputMajor" />
      </div>
      <div class="line">
        <span>{{ t.level }}</span>
        <el-input class="form-input-small" type="text" v-model="inputLevel" />
      </div>
      <div class="line">
        <span>{{ t.yhAccount }}</span>
        <el-input class="form-input-small" type="text" v-model="inputYhAccount" />
      </div>
      <div class="line">
        <span>{{ t.comment }}</span>
        <el-input class="form-input-small" type="text" v-model="inputComment" />
      </div>
      <el-button class="button-half-stretch" type="primary" round @click="updatePlayer">{{
        t.submit
      }}</el-button>
    </div>

    <div class="form-wrapper" v-show="this.store.type === 'playerMatch'">
      <h1>{{ t.queryMatchScores }}</h1>
      <div class="line">
        <span>{{ t.name }}</span>
        <el-input class="form-input" type="text" v-model="playerName" />
      </div>
      <!-- <div class="line">
                <span>籍贯：</span>
                <el-input class="form-input"  type="text" v-model="PlayerNativePlace">
            </div> -->
      <el-button class="button-half-stretch" type="primary" round @click="queryPlayerMatch">{{
        t.query
      }}</el-button>
    </div>

    <div v-show="this.store.type === 'showPlayerMatch'">
      <el-table :data="this.playerMatchList" border style="width: 400px">
        <el-table-column prop="matchName" :label="t.matchName" width="280px" />
        <el-table-column prop="ranking" :label="t.rank" />
      </el-table>
    </div>
  </div>
</template>

<style scoped>
.content-wrapper {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}

.form-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 15px;
  width: 450px;
}

.form-wrapper-compact {
  gap: 10px;
}

.form-wrapper > h1 {
  font-weight: bolder;
  font-size: larger;
  margin-bottom: 10px;
}

.form-input {
  width: 100%;
  height: 40px;
}

.form-input-small {
  width: 100%;
  height: 30px;
}

.admin-login-buttons {
  width: 100%;
  display: flex;
  justify-content: space-between;
}

.button-admin-login {
  width: 200px;
  height: 35px;
}

.button-stretch {
  width: 100%;
  height: 40px;
  font-size: large;
}

.button-half-stretch {
  width: 50%;
  height: 40px;
  font-size: large;
}

.line {
  display: flex;
  align-items: center;
  gap: 10px;
}

.line span {
  display: inline-block;
  font-size: medium;
  text-align: right;
  width: 200px;
}

.line input {
  height: 20px;
  /* border-radius: 3px; */
}

.playerInfo {
  width: 200px;
}
</style>
