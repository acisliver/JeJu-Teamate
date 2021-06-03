import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
// import color from 'vuetify/lib/util/color'

Vue.use(Vuetify)

//vuetify 테마 컬러 설정
const opts = {
    theme: {
        themes: {
            light: {
                primary: "#279F9F",
                secondary: "#008080",
                accent: "#5FBFBF"
            }
        }
    }
}

export default new Vuetify(opts)