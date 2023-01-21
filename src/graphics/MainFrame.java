package graphics;

import abstracts.Publication;
import classes.*;
import enums.Periodicity;
import exceptions.UnacceptableDateException;
import management.Archive;

import java.util.List;

public class MainFrame extends javax.swing.JFrame {
		  
	private static final long serialVersionUID = 1L;
	private static final Archive archive = new Archive();
	
	private javax.swing.ButtonGroup PublicationType;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton backupLoadButton;
    private javax.swing.JButton backupSaveButton;
    private javax.swing.JRadioButton bookRadio;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField deleteField;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JTextField genreField;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JRadioButton magazineRadio;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField pageField;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTextField periodicityField;
    private javax.swing.JLabel periodicityLabel;
    private javax.swing.JLabel radioLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton searchButton1;
    private javax.swing.JButton searchButton2;
    private javax.swing.JButton searchButton3;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel yearLabel; 
    
    // Creates new form MainFrame    
    public MainFrame() {
        initComponents();        
    }
                        
    private void initComponents() {

        PublicationType = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton1 = new javax.swing.JButton();
        searchButton2 = new javax.swing.JButton();
        searchButton3 = new javax.swing.JButton();
        deletionLabel = new javax.swing.JLabel();
        deleteField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        backupSaveButton = new javax.swing.JButton();
        backupLoadButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        isbnLabel = new javax.swing.JLabel();
        isbnField = new javax.swing.JTextField();
        radioLabel = new javax.swing.JLabel();
        bookRadio = new javax.swing.JRadioButton();
        magazineRadio = new javax.swing.JRadioButton();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        yearField = new javax.swing.JTextField();
        pageLabel = new javax.swing.JLabel();
        pageField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        authorField = new javax.swing.JTextField();
        genreLabel = new javax.swing.JLabel();
        genreField = new javax.swing.JTextField();
        periodicityLabel = new javax.swing.JLabel();
        periodicityField = new javax.swing.JTextField();
        periodicityField.setVisible(false);
        periodicityLabel.setVisible(false);
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        archive.readData();
        String listForPrint = "";
        for (Publication pub : archive.getCatalog()) {
            listForPrint += pub.toString() + "\n";
        }
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(45, 48, 71));
        jPanel.setToolTipText("");

        mainTitle.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        mainTitle.setForeground(new java.awt.Color(224, 164, 88));
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Interactive Library Catalog");
        mainTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        leftPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 3, 14), new java.awt.Color(224, 164, 88))); // NOI18N
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(545, 162));

        searchLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 219, 181));
        searchLabel.setText("Search:");

        searchButton1.setText("by Author");
        searchButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton1.setIconTextGap(0);
        searchButton1.setMargin(new java.awt.Insets(2, 0, 3, 0));
        searchButton1.setMaximumSize(new java.awt.Dimension(88, 23));
        searchButton1.setPreferredSize(new java.awt.Dimension(80, 23));
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });

        searchButton2.setText("by ISBN");
        searchButton2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        searchButton2.setMaximumSize(new java.awt.Dimension(80, 23));
        searchButton2.setMinimumSize(new java.awt.Dimension(83, 23));
        searchButton2.setPreferredSize(new java.awt.Dimension(80, 23));
        searchButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton2ActionPerformed(evt);
            }
        });

        searchButton3.setText("by Year");
        searchButton3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        searchButton3.setMaximumSize(new java.awt.Dimension(80, 23));
        searchButton3.setMinimumSize(new java.awt.Dimension(83, 23));
        searchButton3.setPreferredSize(new java.awt.Dimension(80, 23));
        searchButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton3ActionPerformed(evt);
            }
        });

        deletionLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        deletionLabel.setForeground(new java.awt.Color(255, 219, 181));
        deletionLabel.setText("Remove by ISBN Code:");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backupSaveButton.setText("Save Backup on Locale");
        backupSaveButton.setMaximumSize(new java.awt.Dimension(260, 23));
        backupSaveButton.setMinimumSize(new java.awt.Dimension(260, 23));
        backupSaveButton.setPreferredSize(new java.awt.Dimension(260, 23));
        backupSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupSaveButtonActionPerformed(evt);
            }
        });

        backupLoadButton.setText("Load Last Available Backup");
        backupLoadButton.setMaximumSize(new java.awt.Dimension(260, 23));
        backupLoadButton.setMinimumSize(new java.awt.Dimension(260, 23));
        backupLoadButton.setPreferredSize(new java.awt.Dimension(260, 23));
        backupLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupLoadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                        .addComponent(deletionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                        .addComponent(backupSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backupLoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletionLabel)
                    .addComponent(deleteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backupSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(backupLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        rightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add a new Publication to the Catalog", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 3, 14), new java.awt.Color(224, 164, 88))); // NOI18N
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new java.awt.Dimension(560, 162));
        rightPanel.setRequestFocusEnabled(false);

        isbnLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        isbnLabel.setForeground(new java.awt.Color(255, 219, 181));
        isbnLabel.setText("ISBN Code:");
        isbnLabel.setPreferredSize(new java.awt.Dimension(81, 18));

        radioLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        radioLabel.setForeground(new java.awt.Color(255, 219, 181));
        radioLabel.setText("Type:");

        bookRadio.setBackground(new java.awt.Color(0, 0, 0));
        PublicationType.add(bookRadio);
        bookRadio.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        bookRadio.setForeground(new java.awt.Color(255, 219, 181));
        bookRadio.setSelected(true);
        bookRadio.setText("Book");
        bookRadio.setOpaque(false);
        bookRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookRadioActionPerformed(evt);
            }
        });

        magazineRadio.setBackground(new java.awt.Color(0, 0, 0));
        PublicationType.add(magazineRadio);
        magazineRadio.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        magazineRadio.setForeground(new java.awt.Color(255, 219, 181));
        magazineRadio.setText("Magazine");
        magazineRadio.setOpaque(false);
        magazineRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magazineRadioActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 219, 181));
        titleLabel.setText("Title:");
        titleLabel.setPreferredSize(new java.awt.Dimension(82, 18));

        yearLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        yearLabel.setForeground(new java.awt.Color(255, 219, 181));
        yearLabel.setText("Year:");

        pageLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        pageLabel.setForeground(new java.awt.Color(255, 219, 181));
        pageLabel.setText("Pages:");

        authorLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(255, 219, 181));
        authorLabel.setText("Author:");
        authorLabel.setToolTipText("");

        genreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        genreLabel.setForeground(new java.awt.Color(255, 219, 181));
        genreLabel.setText("Genre:");

        periodicityLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        periodicityLabel.setForeground(new java.awt.Color(255, 219, 181));
        periodicityLabel.setText("Periodicity:");

        addButton.setText("Add Publication to Catalog");
        addButton.setMaximumSize(new java.awt.Dimension(253, 23));
        addButton.setMinimumSize(new java.awt.Dimension(253, 23));
        addButton.setPreferredSize(new java.awt.Dimension(253, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear All Fields");
        clearButton.setMaximumSize(new java.awt.Dimension(260, 23));
        clearButton.setMinimumSize(new java.awt.Dimension(260, 23));
        clearButton.setPreferredSize(new java.awt.Dimension(260, 23));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(periodicityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodicityField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorField))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(genreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genreField)
                                .addContainerGap())
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(radioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bookRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(magazineRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookRadio)
                    .addComponent(magazineRadio)
                    .addComponent(radioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel)
                    .addComponent(pageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genreLabel)
                        .addComponent(genreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(periodicityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(periodicityLabel)
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        textArea.setColumns(20);
        textArea.setRows(25);
        scrollPanel.setViewportView(textArea);
        textArea.append(listForPrint);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollPanel)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(mainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void magazineRadioActionPerformed(java.awt.event.ActionEvent evt) {                                              
        genreField.setVisible(false);
        genreLabel.setVisible(false);        
        authorField.setVisible(false);
        authorLabel.setVisible(false);
        periodicityField.setVisible(true);
        periodicityLabel.setVisible(true);
    }                                             

    private void bookRadioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        genreField.setVisible(true);
        genreLabel.setVisible(true);        
        authorField.setVisible(true);
        authorLabel.setVisible(true);
        periodicityField.setVisible(false);
        periodicityLabel.setVisible(false);        
    }                                         
       
    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        printList(archive.searchByAuthor(searchField.getText()));
    }                                             

    private void backupSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        archive.saveData();
        textArea.append("The library catalogue has been correctly saved on the hard drive \n");
    }                                                

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        archive.removeByISBN(deleteField.getText());
        updateCatalog();
        deleteField.setText("");
    }                                            

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        clearInputFields();
    }                                           

    private void clearInputFields() {
        isbnField.setText("");
        titleField.setText("");
        yearField.setText("");
        pageField.setText("");
        periodicityField.setText("");
        authorField.setText("");
        genreField.setText("");
    }
    
    private void updateCatalog() {
        clearInputFields();
        extendedList(archive.getCatalog());        
    }
    
    private void extendedList(List<Publication> list) {
        String extendedList = "";
        for (Publication pub : list) {
            extendedList += pub.toString() + "\n";
        }
        textArea.setText(extendedList);
    }
    
    private void printList(List<Publication> list) {
        if (list.isEmpty()) textArea.append("No result has been found \n");
        else extendedList(list);
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if (Integer.parseInt(yearField.getText()) < 1500) throw new UnacceptableDateException("The publishing year can't be too far in the past \n");            
            else if (Integer.parseInt(yearField.getText()) > 2023) throw new UnacceptableDateException("The publishing year can't be in the future \n");
            else {
                if (bookRadio.isSelected()) {
                    archive.addPublication(new Book(isbnField.getText(), titleField.getText(), Integer.parseInt(yearField.getText()), Integer.parseInt(pageField.getText()), authorField.getText(), genreField.getText()));
                } else {
                    archive.addPublication(new Magazine(isbnField.getText(), titleField.getText(), Integer.parseInt(yearField.getText()), Integer.parseInt(pageField.getText()), Periodicity.valueOf(periodicityField.getText().toUpperCase())));    
                }
            }
            updateCatalog();
        } catch (NumberFormatException e) {
            textArea.append("You have to input a valid number for Years and Pages fields \n");	
        } catch (UnacceptableDateException e) {
            textArea.append(e.getMessage());
        } catch (IllegalArgumentException e) {
            textArea.append("Periodicity can be only expressed as 'Weekly', 'Monthly' or 'Biannual' \n");
        }
    }                                         

    private void backupLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String lastCatalog = "";
        for (Publication pub : archive.readData()) {
            lastCatalog += pub.toString() + "\n";
        }
        textArea.setText(lastCatalog);
    }                                                

    private void searchButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            printList(archive.searchByYear(Integer.parseInt(searchField.getText())));
        } catch (NumberFormatException e) {
            textArea.append("You have to input a valid number \n");
        } finally {
            searchField.setText("");
        }   
    }                                             

    private void searchButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        printList(archive.searchByISBN(searchField.getText()));
    } 

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);                
            }
        });        
    }                   
}
