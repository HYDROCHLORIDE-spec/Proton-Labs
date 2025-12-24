package com.example.protondev

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.ViewQuilt

// Theme Colors
val PrimaryColor = Color(0xFFD946EF) // Fuchsia/Pinkish
val BackgroundColor = Color(0xFF1E0B36) // Deep Purple
val SurfaceColor = Color(0xFF2D1B4E) // Lighter Purple
val TextColor = Color.White
val SecondaryTextColor = Color(0xFFBCAAA4)

val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    onPrimary = Color.White,
    background = BackgroundColor,
    onBackground = TextColor,
    surface = SurfaceColor,
    onSurface = TextColor,
    primaryContainer = SurfaceColor,
    onPrimaryContainer = TextColor
)

@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = DarkColorScheme) {
        val currentScreen = remember { mutableStateOf("home") }

        AnimatedContent(
            targetState = currentScreen.value,
            transitionSpec = { fadeIn(tween(300)) togetherWith fadeOut(tween(300)) }
        ) { screen ->
            when (screen) {
                "home" -> LandingPage(
                    onNavToTerms = { currentScreen.value = "terms" },
                    onNavToHome = { currentScreen.value = "home" },
                    onNavToPrivacy = { currentScreen.value = "privacy" }
                )
                "terms" -> TermsAndConditionsPage(
                     onNavToHome = { currentScreen.value = "home" },
                     onNavToTerms = { currentScreen.value = "terms" },
                     onNavToPrivacy = { currentScreen.value = "privacy" }
                )
                "privacy" -> PrivacyPolicyPage(
                    onNavToHome = { currentScreen.value = "home" },
                    onNavToTerms = { currentScreen.value = "terms" },
                    onNavToPrivacy = { currentScreen.value = "privacy" }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(onNavToHome: () -> Unit, onNavToTerms: () -> Unit, onNavToPrivacy: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onNavToHome() }
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = PrimaryColor,
                    modifier = Modifier.size(32.dp).padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.RocketLaunch,
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("ProtonDev", fontWeight = FontWeight.Bold, color = TextColor, style = MaterialTheme.typography.titleMedium)
                    Text("Innovation in Motion", style = MaterialTheme.typography.labelSmall, color = SecondaryTextColor)
                }
            }
        },
        actions = {
            TextButton(onClick = onNavToHome) { Icon(Icons.Default.RocketLaunch, null, modifier = Modifier.size(16.dp)); Spacer(Modifier.width(4.dp)); Text("Home", color = TextColor) }
            TextButton(onClick = onNavToPrivacy) { Icon(Icons.Default.Lock, null, modifier = Modifier.size(16.dp)); Spacer(Modifier.width(4.dp)); Text("Privacy Policy", color = TextColor) }
            TextButton(onClick = onNavToTerms) { Icon(Icons.Default.Terminal, null, modifier = Modifier.size(16.dp)); Spacer(Modifier.width(4.dp)); Text("Terms & Conditions", color = TextColor) }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = TextColor),
                border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(Color.White.copy(alpha = 0.2f))),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(Icons.Default.Email, null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(8.dp))
                Text("Contact Us")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundColor.copy(alpha = 0.9f))
    )
}

@Composable
fun TechBackground() {
    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF4C1D95).copy(alpha = 0.4f),
                            Color.Transparent
                        ),
                        center = androidx.compose.ui.geometry.Offset(0f, 0f),
                        radius = 1000f
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFFBE185D).copy(alpha = 0.2f),
                            Color.Transparent
                        ),
                        center = androidx.compose.ui.geometry.Offset(1000f, 1000f),
                        radius = 800f
                    )
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingPage(onNavToTerms: () -> Unit, onNavToHome: () -> Unit, onNavToPrivacy: () -> Unit) {
    Scaffold(
        containerColor = BackgroundColor,
        topBar = { MainTopAppBar(onNavToHome, onNavToTerms, onNavToPrivacy) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            TechBackground()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                HeroSection()
                StatsSection()
                ServicesSection()
                TechnologiesSection()
                CtaSection()
                FooterSection()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionsPage(onNavToHome: () -> Unit, onNavToTerms: () -> Unit, onNavToPrivacy: () -> Unit) {
    Scaffold(
        containerColor = BackgroundColor,
        topBar = { MainTopAppBar(onNavToHome, onNavToTerms, onNavToPrivacy) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            TechBackground()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Spacer(Modifier.height(40.dp))
            Surface(
                color = PrimaryColor.copy(alpha=0.1f), // Slight transparency for glow effect
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                 Surface(
                    color = PrimaryColor,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                     Icon(Icons.Default.Description, null, tint = Color.White, modifier = Modifier.size(32.dp).padding(6.dp))
                }
            }
            
            Text(
                "Terms & Conditions",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = TextColor,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                "Please read these terms carefully before using our services. These terms\ngovern your use of ProtonDev's services and products.",
                textAlign = TextAlign.Center,
                color = SecondaryTextColor,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
             Text(
                "Last Updated: January 15, 2024",
                textAlign = TextAlign.Center,
                color = SecondaryTextColor.copy(alpha = 0.6f),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            
            // Intro Card
             Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceColor.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 24.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(0.05f))
            ) {
                 Text(
                    "These Terms and Conditions (\"Terms\") constitute a legally binding agreement between you and ProtonDev (\"Company,\" \"we,\" \"us,\" or \"our\") concerning your access to and use of our services, website, and products. By accessing or using our services, you acknowledge that you have read, understood, and agree to be bound by these Terms. If you do not agree to these Terms, you must not access or use our services.",
                    color = SecondaryTextColor,
                    modifier = Modifier.padding(32.dp),
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.5
                )
            }
            
            // Acceptance of Terms
             ContentCard(
                 title = "Acceptance of Terms", 
                 icon = Icons.Default.CheckCircle,
                 color = Color(0xFFD946EF) // Pink
             ) {
                 ContentItem("Agreement to Terms", "By accessing or using ProtonDev's services, you agree to be bound by these Terms and Conditions. If you do not agree to these terms, please do not use our services.")
             }

            // Services and Usage
            ContentCard(
                title = "Services and Usage",
                icon = Icons.Default.Handshake, // Heart-like handshake
                color = Color(0xFFD946EF) // Pink
            ) {
                ContentItem("Service Description", "ProtonDev provides software development, consulting, and technology services. The specific services provided will be outlined in individual service agreements or statements of work.")
                ContentItem("Acceptable Use", "You agree to use our services only for lawful purposes and in accordance with these terms. You must not use our services in any way that violates applicable laws or regulations.")
                ContentItem("Account Responsibilities", "You are responsible for maintaining the confidentiality of your account credentials and for all activities that occur under your account. You must notify us immediately of any unauthorized use.")
            }
            
            // Intellectual Property
            ContentCard(
                title = "Intellectual Property",
                icon = Icons.Default.Copyright,
                color = Color(0xFFD946EF)
            ) {
                ContentItem("Ownership", "All content, features, and functionality of our services, including but not limited to text, graphics, logos, and software, are owned by ProtonDev and are protected by copyright, trademark, and other intellectual property laws.")
                ContentItem("License Grant", "Subject to these terms, we grant you a limited, non-exclusive, non-transferable license to access and use our services for your internal business purposes.")
                ContentItem("Client Work Product", "Ownership of work product subject to individual service agreements.")
            }
            
            // Payment Terms
             ContentCard(
                title = "Payment Terms",
                icon = Icons.Default.MonetizationOn,
                color = Color(0xFFD946EF)
            ) {
                ContentItem("Fees and Billing", "Fees for our services will be specified in individual service agreements. All fees are exclusive of taxes, which you are responsible for paying.")
                ContentItem("Payment Schedule", "Payment terms will be outlined in your service agreement. Late payments may result in suspension of services and may incur late fees as specified in your agreement.")
                ContentItem("Refund Policy", "Refunds are handled on a case-by-case basis and are subject to the terms of your specific service agreement. Generally, fees for completed work are non-refundable.")
            }
            
            // Warranties and Disclaimers
            ContentCard(
                title = "Warranties and Disclaimers",
                icon = Icons.Default.Warning,
                color = Color(0xFFD946EF)
            ) {
                ContentItem("Service Warranty", "We warrant that our services will be performed in a professional and workmanlike manner consistent with industry standards. This warranty is subject to the limitations outlined in individual service agreements.")
                ContentItem("Disclaimer", "Except as expressly stated, our services are provided \"as is\" without warranties of any kind, either express or implied, including but not limited to warranties of merchantability or fitness for a particular purpose.")
                ContentItem("Third-Party Services", "We are not responsible for any third-party services, products, or content that may be integrated with or accessed through our services.")
            }

            // Limitation of Liability
            ContentCard(
                title = "Limitation of Liability",
                icon = Icons.Default.Security, // Shield
                color = Color(0xFFD946EF)
            ) {
                ContentItem("Liability Cap", "To the maximum extent permitted by law, our total liability for any claims arising out of or relating to these terms or our services shall not exceed the amount paid by you to us in the twelve months preceding the claim.")
                ContentItem("Excluded Damages", "We shall not be liable for any indirect, incidental, special, consequential, or punitive damages, including but not limited to loss of profits, data, or business opportunities.")
                ContentItem("Force Majeure", "We shall not be liable for any failure or delay in performance due to circumstances beyond our reasonable control, including but not limited to acts of God, war, terrorism, or natural disasters.")
            }
            
            // Termination
             ContentCard(
                title = "Termination",
                icon = Icons.Default.Gavel, // Using Gavel or Close/Remove
                color = Color(0xFFD946EF)
            ) {
                ContentItem("Termination Rights", "Either party may terminate services in accordance with the terms specified in individual service agreements. We reserve the right to suspend or terminate access to our services for violation of these terms.")
                ContentItem("Effect of Termination", "Upon termination, you must cease all use of our services. Provisions that by their nature should survive termination shall remain in effect, including intellectual property rights and limitation of liability.")
            }
            
            // Important Notice
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3F1B46).copy(alpha=0.6f)), // Dark reddish/purple-brown
                shape = RoundedCornerShape(16.dp),
                 modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 24.dp),
                 border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF805260))
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom=16.dp)) {
                         Surface(color = Color(0xFFD946EF).copy(0.2f), shape = RoundedCornerShape(8.dp), modifier = Modifier.size(32.dp)) {
                             Box(contentAlignment = Alignment.Center) {
                                 Icon(Icons.Default.Info, null, tint = Color(0xFFFACC15), modifier = Modifier.size(18.dp))
                             }
                         }
                         Spacer(Modifier.width(16.dp))
                         Text("Important Notice", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = TextColor)
                    }
                     Text(
                        "These Terms and Conditions contain important information about your legal rights, remedies, and obligations. Please read them carefully. By using our services, you agree to these terms in their entirety.",
                        color = SecondaryTextColor,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    val points = listOf(
                        "These terms include a binding arbitration clause and class action waiver",
                        "Limitations on our liability are outlined in Section 6",
                        "Your rights and responsibilities are detailed throughout this document"
                    )
                    
                    points.forEach { point ->
                         Row(modifier = Modifier.padding(bottom = 8.dp)) {
                             Text("›", color = Color(0xFFFACC15), fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))
                             Text(point, color = SecondaryTextColor)
                         }
                    }
                }
            }
            
            // Questions
             Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF352048)), 
                shape = RoundedCornerShape(16.dp),
                 modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 24.dp)
            ) {
                 Column(modifier = Modifier.padding(24.dp)) {
                     Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom=16.dp)) {
                         Surface(color = Color(0xFFD946EF), shape = RoundedCornerShape(8.dp), modifier = Modifier.size(32.dp).padding(4.dp)) {
                                 Icon(Icons.Default.Info, null, tint = Color.White)
                         }
                         Spacer(Modifier.width(16.dp))
                         Text("Questions About These Terms?", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = TextColor)
                    }
                    Text(
                        "If you have any questions or concerns about these Terms and Conditions, please contact our legal team. We're here to help clarify any aspects of our terms.",
                         color = SecondaryTextColor,
                         modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                        Button(
                            onClick = { uriHandler.openUri("mailto:neutralinks@gmail.com") },
                            colors = ButtonDefaults.buttonColors(containerColor = SurfaceColor.copy(alpha=0.5f)),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                             Icon(Icons.Default.Email, null, modifier = Modifier.size(16.dp))
                             Spacer(Modifier.width(8.dp))
                             Text("neutralinks@gmail.com", color=TextColor)
                        }
                    }
                 }
            }
            
            // Agreement Check
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A5F).copy(alpha=0.3f)), // Bluish tint
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 60.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF0F4C81).copy(0.3f))
            ) {
                 Column(modifier = Modifier.padding(24.dp)) {
                     Row(verticalAlignment = Alignment.Top) {
                         Icon(Icons.Default.CheckCircle, null, tint = Color(0xFF10B981), modifier = Modifier.padding(top=4.dp))
                         Spacer(Modifier.width(16.dp))
                         Column {
                             Text("Your Agreement", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = TextColor, modifier = Modifier.padding(bottom=8.dp))
                             Text(
                                 "By continuing to use ProtonDev's services, you acknowledge that you have read, understood, and agree to be bound by these Terms and Conditions, as well as our Privacy Policy. If you do not agree to these terms, you must discontinue use of our services immediately.",
                                 color = SecondaryTextColor,
                                 style = MaterialTheme.typography.bodyMedium
                             )
                         }
                     }
                 }
            }
            
            FooterSection()
        }
    }
}
}

@Composable
fun ContentCard(title: String, icon: ImageVector, color: Color, content: @Composable () -> Unit) {
     Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceColor.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 24.dp),
    ) {
        Column(modifier = Modifier.padding(32.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 24.dp)) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = color,
                    modifier = Modifier.size(40.dp).padding(4.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                         Icon(icon, null, tint = Color.White, modifier = Modifier.size(20.dp))
                    }
                }
                Spacer(Modifier.width(16.dp))
                Text(title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = TextColor)
            }
            content()
        }
    }
}

@Composable
fun ContentItem(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = TextColor,
            modifier = Modifier.padding(bottom = 8.dp)
        )
         Text(
            description,
            style = MaterialTheme.typography.bodyMedium,
            color = SecondaryTextColor,
            lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.5
        )
    }
}


@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp, bottom = 60.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = PrimaryColor.copy(alpha = 0.2f),
            shape = RoundedCornerShape(50),
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(
                text = "Welcome to ProtonDev",
                color = PrimaryColor,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }

        Text(
            text = "Building the Future\nOne Line at a Time",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            color = TextColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "We transform innovative ideas into powerful digital solutions that drive business growth and create lasting impact.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = SecondaryTextColor,
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 32.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
            Button(
                onClick = { uriHandler.openUri("mailto:neutralinks@gmail.com") },
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text("Get Started")
            }
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(contentColor = TextColor),
                border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(
                    Color.White.copy(
                        alpha = 0.5f
                    )
                )
                )
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(8.dp))
                Text("Watch Demo")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StatsSection() {
    val stats = listOf(
        Stat("500+", "Projects Completed", Icons.Default.RocketLaunch, Color(0xFFD946EF)),
        Stat("200+", "Happy Clients", Icons.Default.Group, Color(0xFFF472B6)),
        Stat("50+", "Team Members", Icons.Default.Group, Color(0xFFA78BFA)),
        Stat("15+", "Years Experience", Icons.Default.Star, Color(0xFFFBBF24))
    )

    FlowRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center,
        maxItemsInEachRow = 4
    ) {
        stats.forEach { stat ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = PrimaryColor.copy(alpha = 0.1f),
                    modifier = Modifier.size(48.dp).padding(bottom = 8.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(stat.icon, contentDescription = null, tint = PrimaryColor)
                    }
                }
                Text(
                    text = stat.value,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = TextColor
                )
                Text(
                    text = stat.label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = SecondaryTextColor
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ServicesSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Our Services",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextColor,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        val services = listOf(
            Service("Custom Development", "Tailored software solutions built with cutting-edge technologies.", Icons.Default.Code, Color(0xFF3B82F6)),
            Service("Mobile Apps", "Native and cross-platform mobile applications that deliver exceptional user experiences.", Icons.Default.Smartphone, Color(0xFFD946EF)),
            Service("Cloud Solutions", "Scalable cloud infrastructure and services to power your digital transformation.", Icons.Default.Cloud, Color(0xFF10B981)),
            Service("AI & Machine Learning", "Intelligent automation and predictive analytics to drive decisions.", Icons.Default.Speed, Color(0xFFF97316)),
            Service("Cybersecurity", "Comprehensive security solutions to protect your digital assets.", Icons.Default.Lock, Color(0xFF8B5CF6)),
            Service("Analytics & Insights", "Advanced analytics platforms that transform raw data into intelligence.", Icons.Default.Analytics, Color(0xFFEC4899))
        )

        FlowRow(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth()
        ) {
            services.forEach { service ->
                HoverableServiceCard(service, modifier = Modifier.width(350.dp))
            }
        }
    }
}

@Composable
fun HoverableServiceCard(service: Service, modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val scale by animateFloatAsState(targetValue = if (isHovered) 1.05f else 1f, animationSpec = tween(300))
    val elevation = if (isHovered) 12.dp else 4.dp
    val containerColor = if (isHovered) SurfaceColor.copy(alpha = 0.95f) else SurfaceColor.copy(alpha = 0.6f)
    val borderColor = if (isHovered) PrimaryColor.copy(alpha=0.5f) else Color.White.copy(alpha=0.1f)

    Card(
        modifier = modifier
            .scale(scale)
            .hoverable(interactionSource)
            .clickable(interactionSource = interactionSource, indication = null) { },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier.padding(32.dp).fillMaxWidth().height(250.dp), // Fixed height for ratio
            horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
            verticalArrangement = Arrangement.Center // Center vertically
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = service.color.copy(alpha=0.2f),
                modifier = Modifier.size(64.dp).padding(bottom = 16.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(service.icon, contentDescription = null, tint = service.color, modifier = Modifier.size(32.dp))
                }
            }
            Text(
                text = service.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextColor,
                modifier = Modifier.padding(bottom = 12.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = service.description,
                style = MaterialTheme.typography.bodyMedium,
                color = SecondaryTextColor,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            if (isHovered) {
                Text(
                    text = "Learn More →",
                    style = MaterialTheme.typography.labelLarge,
                    color = service.color,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TechnologiesSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Technologies We Use",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextColor,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Leveraging the latest and most powerful technologies",
            style = MaterialTheme.typography.bodyMedium,
            color = SecondaryTextColor,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        val technologies = listOf(
            Tech("Android", Icons.Default.Smartphone, Color(0xFF3DDC84)),
            Tech("iOS", Icons.Default.Phone, Color(0xFF000000)),
            Tech("Web", Icons.Default.Web, Color(0xFFE44D26)),
            Tech("Kotlin", Icons.Default.Code, Color(0xFF7F52FF)),
            Tech("Compose", Icons.Default.ViewQuilt, Color(0xFF4285F4)),
            Tech("AI", Icons.Default.Psychology, Color(0xFFFF6F00)),
            Tech("Cloud", Icons.Default.Cloud, Color(0xFF10B981)),
            Tech("Docker", Icons.Default.Storage, Color(0xFF2496ED))
        )
        
        @OptIn(ExperimentalLayoutApi::class)
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 4,
            modifier = Modifier.fillMaxWidth()
        ) {
            technologies.forEach { tech ->
                Surface(
                    color = SurfaceColor.copy(alpha=0.5f),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.width(140.dp).padding(4.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(0.1f))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(tech.icon, null, tint = tech.color, modifier = Modifier.size(32.dp).padding(bottom=8.dp))
                        Text(tech.name, color = TextColor, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
fun CtaSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFF5B21B6), PrimaryColor)
                ),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(48.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ready to Start Your Project?",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Let's collaborate to bring your vision to life.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 32.dp)
            )
            val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
            Button(
                onClick = { uriHandler.openUri("mailto:neutralinks@gmail.com") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Contact Us Today", color = PrimaryColor, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F0518))
            .padding(top = 40.dp, bottom = 20.dp, start = 24.dp, end = 24.dp)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(bottom = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Column(modifier = Modifier.width(300.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp)) {
                     Icon(Icons.Default.RocketLaunch, null, tint = PrimaryColor)
                     Spacer(Modifier.width(8.dp))
                     Text("ProtonDev", color = TextColor, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                }
                Text(
                    "Leading the future of technology with innovative solutions and cutting-edge development practices.",
                    color = SecondaryTextColor,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            
            Column {
                Text("Quick Links", color = TextColor, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                Text("About Us", color = SecondaryTextColor, modifier = Modifier.padding(bottom = 8.dp))
                Text("Services", color = SecondaryTextColor, modifier = Modifier.padding(bottom = 8.dp))
                Text("Portfolio", color = SecondaryTextColor, modifier = Modifier.padding(bottom = 8.dp))
                Text("Careers", color = SecondaryTextColor)
            }
            
            Column {
                Text("Contact", color = TextColor, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))

                val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                Row(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .clickable { uriHandler.openUri("mailto:neutralinks@gmail.com") }
                ) {
                    Icon(Icons.Default.Email, null, tint = SecondaryTextColor, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("neutralinks@gmail.com", color = SecondaryTextColor)
                }
            }
        }
        
        HorizontalDivider(color = Color.White.copy(0.1f))
        
        Text(
            "© 2024 ProtonDev. All rights reserved.",
            color = SecondaryTextColor,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 20.dp)
        )
    }
}

data class Service(val title: String, val description: String, val icon: ImageVector, val color: Color)
data class Stat(val value: String, val label: String, val icon: ImageVector, val color: Color)
data class Tech(val name: String, val icon: ImageVector, val color: Color)


