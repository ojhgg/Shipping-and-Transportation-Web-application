---
title: shipping v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---
姓名：胡嘉铖
学号：20301072
代码仓库地址：
作业一：https://github.com/xixilili423/-A-Shipping-and-Transportation-Web-Services-.git
作业二：https://gitee.com/hu-jiacheng1/assignment-2
作业三：
https://gitee.com/hu-jiacheng1/vue-project
作业四：https://gitee.com/hu-jiacheng1/assignment-4

# shipping

> v1.0.0

Base URLs:

# user

## POST register

POST /user/register

> Body 请求参数

```json
{
  "id": "string",
  "address": "string",
  "createdAt": "string",
  "password": "string",
  "contactname": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 否 |none|
|body|body|object| 否 |none|
|» id|body|string| 是 |none|
|» address|body|string| 是 |none|
|» createdAt|body|string| 是 |none|
|» password|body|string| 是 |none|
|» contactname|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "status_code": true
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status_code|boolean|true|none||none|

## POST login

POST /user/login

> Body 请求参数

```json
{
  "username": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» username|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": null,
  "message": null,
  "data": {
    "status_code": true,
    "token": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|null|true|none||none|
|» message|null|true|none||none|
|» data|object|true|none||none|
|»» status_code|boolean|true|none||none|
|»» token|string|true|none||none|

## POST tracking

POST /user/tracking

> Body 请求参数

```json
{
  "itemid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» itemid|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "address": "string",
  "status_code": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» address|string|true|none||none|
|» status_code|string|true|none||none|

## POST createOrder

POST /user/createOrder

> Body 请求参数

```json
{
  "deliveryinstructions": "string",
  "returnto": "string",
  "shipfrom": "string",
  "shipto": "string",
  "type": "string",
  "parcels": {
    "boxtype": "string",
    "description": "string",
    "weight": "string",
    "parcelsid": "string",
    "quantity": "string"
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» deliveryinstructions|body|string| 是 |none|
|» returnto|body|string| 是 |none|
|» shipfrom|body|string| 是 |none|
|» shipto|body|string| 是 |none|
|» type|body|string| 是 |none|
|» parcels|body|object| 是 |none|
|»» boxtype|body|string| 是 |none|
|»» description|body|string| 是 |none|
|»» weight|body|string| 是 |none|
|»» parcelsid|body|string| 是 |none|
|»» quantity|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "success": null,
  "message": null,
  "data": {
    "status_code": true
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|null|true|none||none|
|» message|null|true|none||none|
|» data|object|true|none||none|
|»» status_code|boolean|true|none||none|

## POST billing

POST /user/billing

> Body 请求参数

```json
{
  "accountnumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» accountnumber|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

