# [GeoJSON](https://github.com/bromine0x23/geojson)
当前版本：`0.0.1`

GeoJSON 处理库，支持Jackson序列化

## 使用

```java
FeatureCollection featureCollection = new ObjectMapper().readValue(inputStream, FeatureCollection.class);
```