Demo:接口

以下接口都是POST请求；
1、{ip}:{port}/getDimAppById    通过ID查询
参数:
{
    "id":3
}
返回：
{
    "code": 200,
    "msg": "Success",
    "data": [
        {
            "ID": 3,
            "NAME": "dogsong",
            "AGE": 18
        }
    ]
}
curl命令：
curl -H "Content-Type:application/json" -X POST -d '{"id": "3"}' http://10.0.3.96:10001/getDimAppById
注：
1、10.0.3.96 为IP；
2、10001 为port；

2、{ip}:{port}/listDimAppAll    查询全部
输入:
{}
输出：
{
    "code": 200,
    "msg": "Success",
    "data": [
        {
            "ID": 3,
            "NAME": "dogsong",
            "AGE": 18
        },
        {
            "ID": 4,
            "NAME": "zhangsan",
            "AGE": 22
        },
        {
            "ID": 5,
            "NAME": "domi",
            "AGE": 18
        }
    ]
}
curl命令：
curl -H "Content-Type:application/json" -X POST -d '{}' http://10.0.3.96:10001/listDimAppAll
注：
1、10.0.3.96 为IP；
2、10001 为port；

3、{ip}:{port}/insertDimApp    插入
参数:
{
    "name":"lisi",
    "age":23
}
输出：
{
    "code": 200,
    "msg": "Success",
    "data": "插入成功"
}
curl命令：
curl -H "Content-Type:application/json" -X POST -d '{"name":"wangwu","age":23}' http://10.0.3.96:10001/insertDimApp
注：
1、10.0.3.96 为IP；
2、10001 为port；

4、{ip}:{port}/deleteDimAppById    通过ID删除
参数：
{
    "id":6
}
输出：
{
    "code": 200,
    "msg": "Success",
    "data": "删除成功"
}
curl命令：
curl -H "Content-Type:application/json" -X POST -d '{"id":"6"}' http://10.0.3.96:10001/deleteDimAppById
注：
1、10.0.3.96 为IP；
2、10001 为port；

5、{ip}:{port}/updateDimAppById    通过ID修改
参数：
{
    "id":5,
    "name":"domi",
    "age":24
}
输出：
{
    "code": 200,
    "msg": "Success",
    "data": "更新成功"
}
curl命令：
curl -H "Content-Type:application/json" -X POST -d '{"id":"5","name":"domi","age":"16"}' http://10.0.3.96:10001/updateDimAppById
注：
1、10.0.3.96 为IP；
2、10001 为port；