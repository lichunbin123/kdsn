from peewee import *


def connect_to_db():
    """连接数据库"""
    db = MySQLDatabase('usping', user='root', passwd='123456')
    db.connect()
    return db


db = connect_to_db()


class BaseModel(Model):
    class Meta:
        database = db


class Product(BaseModel):
    id = IntegerField()
    title = CharField()
    keywords = CharField()
    text = TextField()
    company = CharField()
    type = CharField()
    url = CharField()
    picture = CharField()
    assortment1 = CharField()
    assortment2 = CharField()
    assortment3 = CharField()
    assortment4 = CharField()
    assortment5 = CharField()
    assortment6 = CharField()
    uid = IntegerField



