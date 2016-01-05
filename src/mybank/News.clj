(ns mybank.News
    (:refer-clojure :exclude [get])
    (:require [clojure.java.jdbc :as jdbc]
      [clojure.java.jdbc.sql :as sql]
      ))

(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/news"
               :user "root"
               :password "root"
               })

(defn getNews []
      (jdbc/query mysql-db
                ["SELECT * FROM news n"]))

(defn insert
      [body]
      (jdbc/insert! mysql-db :news body))

(defn delete [id]
      (jdbc/delete! mysql-db :news (sql/where {:id id})))

(defn update [id params]
      (jdbc/update! mysql-db :news params (sql/where {:id id})))