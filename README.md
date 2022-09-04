# GIF
<img src ="https://user-images.githubusercontent.com/55987416/188170357-7988ddf1-2e1a-4e24-b0de-e7d90abbc126.gif" width = 324 height = 702/> 

## Eager vs Lazy filters 
++Lazy yöntemde sequence kullanılırken Eager'da iterable kullanılır. Iterable ve Sequence'se birebir aynı fonksiyonu sunan birer interfacetir. Lazy filter ihtiyaç oldukça verilere sorgu atıp çekerken Eager filter ise bir sorguda tüm verileri çeker. Lazy'nin dezavantajı ilişkili verileri gösterirken örneğin, personel adı personel numarası gibi. Çok fazla sorgu göndereceği için Eagar dan yavaş kalır. İlişki olmayan veriler üzerinde işlem yaparkense Eager yavaştır. Çünkü tüm veriyi indirdiğinden gereksiz veriler arasında işlem yaparak geç kalır. 
