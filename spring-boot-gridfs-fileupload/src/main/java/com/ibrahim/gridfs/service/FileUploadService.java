package com.ibrahim.gridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile file) throws IOException {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("FileName", file.getName());
        dbObject.put("ContentType", file.getContentType());
        dbObject.put("Size", file.getSize());
        dbObject.put("userId", "12345"); //dbobject objeyi tanimlayan bir hashmap gibidir, objenin ozelliklerini gireriz
        //aslinda bunlarin hepsi metadata dir
        ObjectId id = gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(), dbObject); //yuklenen file in byte datasini gridFsTemplate araciligi ile kaydet
        System.out.println(id.toString());
        //gridfs template mongodb ye gonderecek
        //mongodb ozelliklerimizi application.properties icerisine yazacagiz, yazmazsan default ozellikler kullanir ve default veri tabanina kaydeder
    }
}
