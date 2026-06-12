<!-- Mail-Client-Jakartamail-Java — README -->
<div align="center">

# ✦ Mail-Client-Jakartamail-Java ✦
### Cliente SMTP · Jakarta Mail · Java 21 · SSL/TLS

![Java](https://img.shields.io/badge/Java-21-ff9f43?style=flat-square&logo=openjdk&logoColor=0f0a0d)
![Jakarta Mail](https://img.shields.io/badge/Jakarta_Mail-ff6b9d?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-cc8870?style=flat-square&logo=apachemaven&logoColor=0f0a0d)
![DAM](https://img.shields.io/badge/Módulo-Servicios_en_Red-ffe066?style=flat-square)

</div>

---

## 📋 Descripción

Cliente de correo SMTP desarrollado con **Jakarta Mail y Java 21**, diseñado como módulo de comunicación para un software de gestión farmacéutica que permite el **envío automático de alertas de stock y pedidos**.

Implementación modular con soporte para múltiples protocolos de seguridad y múltiples destinatarios.

---

## ✨ Funcionalidades

- 📧 **Envío SSL** — puerto 465 con autenticación
- 🔒 **Envío TLS** — puerto 587 con STARTTLS
- 📨 **Envío sin autenticación** — para servidores internos
- 👥 **Múltiples destinatarios** — `addRecipient()` y `addRecipients(String[])`
- 🧩 **Diseño modular** — clase `MailClient` reutilizable e independiente del contexto

---

## 🛠️ Stack

![Java](https://img.shields.io/badge/Java_21-ff9f43?style=flat-square&logo=openjdk&logoColor=0f0a0d)
![Jakarta Mail](https://img.shields.io/badge/Jakarta_Mail_API-ff6b9d?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-cc8870?style=flat-square&logo=apachemaven&logoColor=0f0a0d)

---

## 📁 Estructura del proyecto

```
Mail-Client-Jakartamail-Java/
├── src/main/java/com/ejemplo/
│   ├── App.java          # Ejemplo de uso: Gmail SMTP con SSL
│   └── MailClient.java   # Clase principal: SSL, TLS y envío sin auth
└── pom.xml               # Dependencia Jakarta Mail
```

---

## 🚀 Uso básico

```java
// Crear cliente apuntando al servidor SMTP
MailClient client = new MailClient("smtp.gmail.com", 465);

// Configurar remitente y destinatarios
client.setSender("origen@gmail.com");
client.addRecipient("destino@gmail.com");
client.addRecipients(new String[]{"otro@gmail.com", "mas@gmail.com"});

// Configurar asunto y cuerpo
client.setSubject("Alerta de stock");
client.setMailText("El producto X está por debajo del mínimo.");

// Enviar con SSL
client.sendUsingSSLAuthentication("origen@gmail.com", "contraseña");

// O con TLS
client.sendUsingTLSAuthentication("origen@gmail.com", "contraseña");
```

---

<div align="center">
<sub>Proyecto del módulo Servicios en Red · CFGS DAM · CESUR Málaga ☕</sub>
</div>
