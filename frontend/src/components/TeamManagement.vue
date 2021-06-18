/<template>
  <div class="team-management row justify-center">
    <v-card style="width: 20rem; margin: 5rem;">
      <v-card-text>
        <v-text-field
            v-model="email"
            :rules="[rules.requiredRule]"
            label="팀명"
            required
        ></v-text-field>


      </v-card-text>

      <v-divider class="mt-12"></v-divider>

      <v-card-actions>
        <v-btn
            text
            @click="$router.back()"
        >
          취소
        </v-btn>
        <v-spacer></v-spacer>

        <v-btn
            color="primary"
            text
            @click="signup({email, password, job})"
        >
          수정
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TeamManagement",
  data () {
    return {
      email: null,
      password: null,
      rePassword: null,
      isShow1: false,
      isShow2: false,
      jobs: ["프로그래머", "디자이너", "기획자"],
      job: null,
      rules: {
        requiredRule: v => !!v || '필수입력입니다.',
        maxCharRule: v => v.length <= 25 || '최대 25자 입니다',
        passwordRule: v => {
          //8-25자리 비밀번호
          const pattern = /^.*(?=^.{8,25}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/
          return pattern.test(v) || '비밀번호 형식이 맞지 않습니다'
        },
        emailRule: v => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(v) || '이메일 형식이 아닙니다'
        },
        phoneNumRule: v => {
          const pattern = /^\d{3}-\d{3,4}-\d{4}$/;
          return pattern.test(v) || '전화번호 형식이 맞지 않습니다'
        }
      },
    }
  },
  methods: {
    // validatePassword(password, repassword){
    //   if(password !==repassword){
    //     return
    //   }
    // },
    signup(signupObj) {
      console.log(signupObj)
      axios.post("/api/sign-up",signupObj)
          .then(res => {
            this.$router.push({ name: "login"})
            console.log(res)
          })
          .catch(err => {
            console.log(err)
          })
    }
  }
}
</script>

<style scoped>

</style>