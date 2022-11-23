/*
 Navicat Premium Data Transfer

 Source Server         : MongoDBTest
 Source Server Type    : MongoDB
 Source Server Version : 60002
 Source Host           : localhost:27017
 Source Schema         : mongoDBTest

 Target Server Type    : MongoDB
 Target Server Version : 60002
 File Encoding         : 65001

 Date: 22/11/2022 11:24:32
*/


// ----------------------------
// Collection structure for city
// ----------------------------
db.getCollection("city").drop();
db.createCollection("city");

// ----------------------------
// Documents of city
// ----------------------------
db.getCollection("city").insert([ {
    _id: NumberLong("0"),
    provinceId: NumberLong("0"),
    cityName: "string",
    description: "string",
    _class: "lynu.chaohl.SpringbootIntegration.mongoDBDemo.domain.City"
} ]);
db.getCollection("city").insert([ {
    _id: NumberLong("1"),
    provinceId: NumberLong("1"),
    cityName: "string1",
    description: "string1",
    _class: "lynu.chaohl.SpringbootIntegration.mongoDBDemo.domain.City"
} ]);
