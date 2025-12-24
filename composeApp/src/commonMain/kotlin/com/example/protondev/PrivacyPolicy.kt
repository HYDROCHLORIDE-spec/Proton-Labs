package com.example.protondev

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyPage(
    onNavToHome: () -> Unit,
    onNavToTerms: () -> Unit,
    onNavToPrivacy: () -> Unit
) {
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
                    color = PrimaryColor.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(bottom = 24.dp)
                ) {
                    Surface(
                        color = PrimaryColor,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            Icons.Default.Security,
                            null,
                            tint = Color.White,
                            modifier = Modifier.size(32.dp).padding(6.dp)
                        )
                    }
                }

                Text(
                    "Privacy Policy",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    "Your privacy is important to us. This policy explains how we collect, use, and\nprotect your personal information.",
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
                        "At ProtonDev, we are committed to protecting your privacy and ensuring the security of your personal information. This Privacy Policy describes how we collect, use, disclose, and safeguard your information when you use our services, visit our website, or interact with us in any way. Please read this policy carefully to understand our practices regarding your personal data.",
                        color = SecondaryTextColor,
                        modifier = Modifier.padding(32.dp),
                        lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.5
                    )
                }

                // Information We Collect
                ContentCard(
                    title = "Information We Collect",
                    icon = Icons.Default.Info,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Personal Information",
                        "We collect information that you provide directly to us, including your name, email address, phone number, company name, and any other information you choose to provide when using our services or contacting us."
                    )
                    ContentItem(
                        "Usage Data",
                        "We automatically collect certain information about your device and how you interact with our services, including IP address, browser type, operating system, referring URLs, and pages visited."
                    )
                    ContentItem(
                        "Cookies and Tracking",
                        "We use cookies and similar tracking technologies to track activity on our services and hold certain information to improve and analyze our services."
                    )
                }

                // How We Use Your Information
                ContentCard(
                    title = "How We Use Your Information",
                    icon = Icons.Default.Settings,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Service Delivery",
                        "We use your information to provide, maintain, and improve our services, process transactions, and send you technical notices and support messages."
                    )
                    ContentItem(
                        "Communication",
                        "We may use your information to communicate with you about products, services, offers, promotions, and events, and provide news and information we think will interest you."
                    )
                    ContentItem(
                        "Analytics and Improvement",
                        "We use the information to monitor and analyze trends, usage, and activities in connection with our services and to improve our offerings."
                    )
                }

                // Information Sharing
                ContentCard(
                    title = "Information Sharing",
                    icon = Icons.Default.Share,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Service Providers",
                        "We may share your information with third-party service providers who perform services on our behalf, such as payment processing, data analysis, email delivery, and hosting services."
                    )
                    ContentItem(
                        "Legal Requirements",
                        "We may disclose your information if required to do so by law or in response to valid requests by public authorities, such as a court or government agency."
                    )
                    ContentItem(
                        "Business Transfers",
                        "We may share or transfer your information in connection with, or during negotiations of, any merger, sale of company assets, financing, or acquisition of all or a portion of our business."
                    )
                }

                // Data Security
                ContentCard(
                    title = "Data Security",
                    icon = Icons.Default.Security,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Security Measures",
                        "We implement appropriate technical and organizational measures to protect your personal information against unauthorized or unlawful processing, accidental loss, destruction, or damage."
                    )
                    ContentItem(
                        "Encryption",
                        "We use industry-standard encryption protocols to protect sensitive data during transmission and storage."
                    )
                    ContentItem(
                        "Access Controls",
                        "We maintain strict access controls and only authorized personnel have access to personal information on a need-to-know basis."
                    )
                }

                // Your Rights
                ContentCard(
                    title = "Your Rights",
                    icon = Icons.Default.Person,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Access and Correction",
                        "You have the right to access, update, or correct your personal information at any time by contacting us or through your account settings."
                    )
                    ContentItem(
                        "Data Deletion",
                        "You may request deletion of your personal information, subject to certain exceptions prescribed by law."
                    )
                    ContentItem(
                        "Opt-Out",
                        "You can opt-out of receiving promotional communications from us by following the unsubscribe instructions in those communications or by contacting us directly."
                    )
                }

                // Data Retention
                ContentCard(
                    title = "Data Retention",
                    icon = Icons.Default.Schedule,
                    color = Color(0xFFD946EF)
                ) {
                    ContentItem(
                        "Retention Period",
                        "We retain your personal information for as long as necessary to fulfill the purposes outlined in this privacy policy, unless a longer retention period is required or permitted by law."
                    )
                    ContentItem(
                        "Deletion Process",
                        "When we no longer need your information, we will securely delete or anonymize it in accordance with our data retention policies."
                    )
                }

                // Questions
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF352048)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 24.dp)
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            Surface(
                                color = Color(0xFFD946EF),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.size(32.dp).padding(4.dp)
                            ) {
                                Icon(Icons.Default.Email, null, tint = Color.White)
                            }
                            Spacer(Modifier.width(16.dp))
                            Text(
                                "Questions About Privacy?",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TextColor
                            )
                        }
                        Text(
                            "If you have any questions or concerns about this Privacy Policy or our data practices, please don't hesitate to contact us. We're here to help and ensure your privacy is protected.",
                            color = SecondaryTextColor,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                            Button(
                                onClick = { uriHandler.openUri("mailto:neutralinks@gmail.com") },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = SurfaceColor.copy(
                                        alpha = 0.5f
                                    )
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Icon(Icons.Default.Email, null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("neutralinks@gmail.com", color = TextColor)
                            }
                        }
                    }
                }

                // Policy Updates
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A5F).copy(alpha = 0.3f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 60.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        Color(0xFF0F4C81).copy(0.3f)
                    )
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(verticalAlignment = Alignment.Top) {
                            Icon(
                                Icons.Default.Refresh,
                                null,
                                tint = Color(0xFF3B82F6),
                                modifier = Modifier.padding(top = 4.dp).size(20.dp)
                            )
                            Spacer(Modifier.width(16.dp))
                            Column {
                                Text(
                                    "Policy Updates",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = TextColor,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    "We may update this Privacy Policy from time to time to reflect changes in our practices or for other operational, legal, or regulatory reasons. We will notify you of any material changes by posting the new Privacy Policy on this page and updating the \"Last Updated\" date.",
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
