<template>
    <div>
        <!-- 展示客户信息区 -->
        <el-card class="input-card">
            <el-tabs v-model="defaultTab" @tab-click="handleClick" >
                <el-tab-pane label="输入包裹ID获取位置信息" name="first">
                    <el-form :inline="true" :model="newOutOrder" class="mag" ref="Order"  >
                        <el-form-item label="备注:" prop="id">
                            <el-input v-model="newOutOrder.itemid" placeholder="ID"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary"  @click="fetchNewTable('Order')">查询</el-button>
                        </el-form-item>
                    </el-form>
                </el-tab-pane>
            </el-tabs>
            <div :inline="true">
                <el-form :inline="true" :model="checkForm" ref="checkForm">
                    <el-form-item prop="address" label-position="left" >
                        <span slot="label">包裹目前位置:</span>
                        <el-tag size="small" >{{ checkForm.returnTo }}</el-tag>
                    </el-form-item>
                    <el-form-item style="display: inline-block" prop="time">
                        <span slot="label"  class="span-text">最后一次定位时间:</span>
                        <el-tag size="small" >{{checkForm.time}}</el-tag>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
import user from "@/api/user";
export default {
data() {
    return {
        newOutOrder:{
            itemid:''
        },
        Loading: false, // 加载中动画
        checkForm:{
             returnTo:'',
            time:''
            }
        }
    },
methods: {
    // 该方法用于刷新表格
    fetchNewTable(formName) {
        this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log("刷新表格")
                    console.log("checkForm里面的东西：" + this.newOutOrder.itemid)
                    console.log("传给后端的Form：" + this.newOutOrder)
                    user.checkOrder(this.newOutOrder).then(res => {
                        console.log("checkForm:" + this.checkForm)
                        if (res.data.status_code === true) {
                            this.checkForm.returnTo = res.data.address
                            this.checkForm.time = res.data.time
                            console.log("地址：" + res.data.address)
                        }
                        else {
                            this.$message({
                                message: '包裹位置获取失败',
                                type: 'error'
                            })
                        }
                    })
                }
            })
    },
    // 该方法用于清除填入的信息
    clearFilter(formName) {
        this.$refs[formName].resetFields();
    },
    //清除筛选器等
    resetDateFilter() {
        this.$refs['tableData'].clearFilter()
        // this.$refs['tableData'].clearSort()
        // this.$refs['tableData'].clearSelection();
    },
    // 该方法在每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.currentPage = 1;
        this.pageSize = val;
    },
    // 该方法在当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currentPage = val;
    }
}
}
</script>

<style></style>