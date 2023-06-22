<template>
    <div class="login_container">
      <div class="login">
        <div class="login-form">
          <h2>登录</h2>
          <!--model数据对象，rules整体表单验证规则，ref用来引用整体表单，prop整体规则中的单项规则-->
          <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="70px">
            <el-form-item label="用户名" prop="username">
              <el-input prefix-icon="el-icon-user" placeholder="请填写用户名" maxlength="32" v-model="loginForm.username" ></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password"  v-show="!isCode">
              <el-input prefix-icon="el-icon-lock" placeholder="请填写 6-18 位密码" type="password" maxlength="18" v-model="loginForm.password" show-password></el-input>
            </el-form-item>
            <el-form-item class="btn-r" label-width="0px">
              <el-button type="primary"  class="btn " icon="el-icon-s-promotion" :loading="loading" @click="submitForm('loginForm')">登 录</el-button>
            </el-form-item>
            <el-form-item class="btn-l" label-width="0px">
              <router-link to="/register">
              <el-button type="success" icon="el-icon-back">注 册</el-button></router-link>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
    </template>

  <script>
  import user from '@/api/user'
  
  export default {
      data() {
          var username = (rule, value, callback) => {
              if (!value) {
                  return callback(new Error('请输入用户名'))
              } else {
                  callback()
              }
          }

          var password = (rule, value, callback) => {
              if (!value) {
                  return callback(new Error('请输入密码'))
              } else if (!/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,16}$/.test(value)) {
                  return callback(new Error('密码长度在3-16个字符,只能包含数字、大小写字母'))
              } else {
                  callback()
              }
          }
          return {
              isCode: false,
              loading: false,//加载效果
              loginForm: {
                  username: '',
                  password:''
              },
              rules: {
                  username: [
                      {validator: username, trigger: 'blur'}
                  ],
                  password: [
                      {validator: password, trigger: 'blur'}
                  ]
              }
          }
      },
      methods: {
          // 清空表单
          clearForm(formName) {
              this.$refs[formName].resetFields()
          },
          // 登录
          submitForm(formName) {
              //账户密码正确后，根据返回数据判断用户是否是新用户，若是则跳到仓库初始化
              this.$refs[formName].validate((valid) => {//表单验证'
                  if (valid) {
                      this.loading = true
                      user.login(this.loginForm).then(res => {
                          if (res.data.status_code === true) {
                              //保存token、用户权限类型、用户名
                              localStorage.setItem('token', res.data.token)
                              localStorage.setItem('userID', this.loginForm.username)
                              // 注册成功
                              this.$message({
                                  message: '登录成功',
                                  type: 'success'
                              })
                              this.$router.push({path:'/home'})
                          } else {
                             // console.error(error);
                              this.$message({
                                  message: '登录失败，请检查用户名和密码是否正确。',
                                  type: 'error',
                              });
                          }
                      })
                          .finally(_ => {
                              this.loading = false
                          })
                  }
              })
          }
      }
  }
  </script>
  
  <style>
  .login_container {
      background-image: url("../../assets/welcome.jpg");
      height: 900px;
  }
  
  .login {
    background-color: transparent !important;
    height: 100%;
  
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .login-form {
    height: 300px;
    width: 500px;
    box-sizing: border-box;
    background-color: #fff;
    border-radius: 10px;
    opacity: 0.8;
    padding: 10px 50px;
  }
  
  .login input::-webkit-outer-spin-button,
  .login input::-webkit-inner-spin-button {
      -webkit-appearance: none;
  }
  
  .login input[type='number'] {
      -moz-appearance: textfield;
  }
  
  .btn-r {
    width: 100px;
    float: right;
  }
  
  .btn-l {
    width: 100px;
    float: left;
  }

  
  .findPassword {
    padding: 0px 50px;
  }

  /* .initDialog{

  } */
  </style>
  